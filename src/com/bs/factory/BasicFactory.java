package com.bs.factory;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Properties;

import com.bs.annotation.Tran;
import com.bs.dao.Dao;
import com.bs.service.Service;
import com.bs.utils.TransactionManager;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/


public class BasicFactory {
	/* 反射的作用： 
	 * 在运行时检测对象的类型
	 * 动态构造某个类的对象
	 * 任意调用对象方法
	 * 修改构造函数 方法 属性的可见性 */
	
	private static BasicFactory factory=new BasicFactory();
	private static Properties pro=null;
	private BasicFactory(){}
	static{
		try {
			pro=new Properties();
			pro.load(BasicFactory.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static BasicFactory getFactory(){
		return factory;
	}
	@SuppressWarnings("unchecked")
	//告诉编译器忽略 unchecked 警告信息，如使用List，ArrayList等未进行参数化产生的警告信息。
	public <T extends Dao> T getDao(Class<T> claszz){
		String infName=claszz.getSimpleName();
		String implName=pro.getProperty(infName);
		// 创建实例
		T t=null;
		try {
			//Class.forName()方法可以通过类或接口的名称（一个字符串或完全限定名）来获取对应的Class对象。forName方法会触发类的初始化。
			t=(T)Class.forName(implName).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
	}
	@SuppressWarnings("unchecked")
	public <T extends Service> T getService(Class<T> claszz){
		try {
			String infName=claszz.getSimpleName();
			String implName=pro.getProperty(infName);
				final T service=(T)Class.forName(implName).newInstance();
				T proxyService=(T) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
					if(method.isAnnotationPresent(Tran.class)){
						try {
							TransactionManager.startcon();
							Object obj=method.invoke(service, args);
							TransactionManager.commit();
							return obj;
						}catch(InvocationTargetException e){
								throw new RuntimeException(e.getTargetException());
						}catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new RuntimeException(e);
						}finally{
							TransactionManager.release();
						}
					}else{
						return method.invoke(service, args);
					}
					}
				});
			
			return proxyService;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
