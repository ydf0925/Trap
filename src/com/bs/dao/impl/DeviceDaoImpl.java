
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.DeviceDao;
import com.bs.entity.Device;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午4:10:17 
* @version 1.0 
*/
public class DeviceDaoImpl implements DeviceDao {
	
	@Override
	public void addDevice(Device device) {
		String sql="insert into t_device_details values(null,?,?,?,?)";
		//String sql2="select max(id)as id from t_case_details";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,device.getTitle(),device.getCid(),device.getContent(),device.getImgname());
			//device=runner.query(sql2, new BeanHandler<Device>(Device.class));
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		//return device.getId();
	}

	@Override
	public void deleteDevice(int id) {
		String sql="delete from t_device_details  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateDevice(Device device) {
		String sql="update t_device_details set title=?,cid=?,content=?,imgname=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,device.getTitle(),device.getCid(),device.getContent(),device.getImgname(),device.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	
	@Override
	public void updateImg(Device device) {
		String sql="update t_device_details set imgname=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,device.getImgname(),device.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<Device> selectDeviceList() {
		try {
			String sql="select d.id,d.title,d.cid,d.content,d.imgname, "
					+ "c.name as cname from t_device_details d left join t_device_show c on d.cid=c.id ";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Device>(Device.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Device> selectByCid(int cid) {
		try {
			String sql="select id,title,cid,content,imgname from t_device_details where cid=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<Device>(Device.class),cid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Device selectById(int id) {
		try {
			String sql="select id,title,cid,content,imgname from t_device_details where id=?";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanHandler<Device>(Device.class),id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
