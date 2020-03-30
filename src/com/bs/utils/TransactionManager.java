package com.bs.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/
public class TransactionManager {
	//如果中间有一个操作出现异常，那么回滚之前的所有操作。
	//访问数据库时提供对事务的管理。
	private TransactionManager() {
	}
	//--数据源,整个程序中都只有这一个数据源
	private static DataSource source = new ComboPooledDataSource();
	
	//--是否开启事务的标记
	private static ThreadLocal<Boolean> flag_loc = new ThreadLocal<Boolean>(){
		@Override
		protected Boolean initialValue() {
			return false;
		};
	};
	//保存真实链接的代理链接，改造close方法
	private static ThreadLocal<Connection> proxy_con=new ThreadLocal<Connection>(){};
	//保存真正的链接
	private static ThreadLocal<Connection> real_con=new ThreadLocal<Connection>(){};
	/*public static Connection getCon(){
		return threadloc.get();
	}*/
	//开启事务
	public static void startcon() throws SQLException{
		flag_loc.set(true);//设置事务标记为true
		final Connection con=source.getConnection();
		con.setAutoCommit(false);
		real_con.set(con);
		Connection proxyCon=(Connection)Proxy.newProxyInstance(con.getClass().getClassLoader(), con.getClass().getInterfaces(),
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						if("close".equals(method.getName())){
							return null;
						}else{
							return method.invoke(con, args);
						}
					}
				});
			proxy_con.set(proxyCon);
	}
	
	//提交事务
	public static void commit(){
		DbUtils.commitAndCloseQuietly(proxy_con.get());
	}
	//事务回滚
	public static void rollback(){
		DbUtils.rollbackAndCloseQuietly(proxy_con.get());
	}
	/**
	 * 这个方法应该做到:
	 * 		如果没有开启过事务,则返回最普通的数据源
	 * 		如果开启过事务,则返回一个改造过getConnection方法的数据源,这个方法改造后每次都返回同一个开启过事务的Connection
	 * @return
	 * @throws SQLException 
	 */
	public static DataSource getSource(){
		if(flag_loc.get()){//--如果开启过事务,则返回改造的DataSource,改造为每次调用getConnection都返回同一个开启过事务的Conn
			return (DataSource) Proxy.newProxyInstance(source.getClass().getClassLoader(), source.getClass().getInterfaces(), 
					new InvocationHandler() {
						
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							if("getConnection".equals(method.getName())){
								return proxy_con.get();
							}else{
								return method.invoke(source, args);
							}
						}
					});
			
		}else{
			return source;
		}
	}
	//释放线程资源
	public static void release(){
		DbUtils.closeQuietly(real_con.get());//--之前连接是没有关闭的在release的时候真正的关闭连接
		real_con.remove();
		proxy_con.remove();
		flag_loc.remove();
		
	}
}
