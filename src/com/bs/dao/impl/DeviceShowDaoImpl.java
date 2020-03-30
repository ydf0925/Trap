
package com.bs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bs.dao.DeviceShowDao;
import com.bs.entity.DeviceShow;
import com.bs.utils.TransactionManager;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月18日 下午3:30:11 
* @version 1.0 
*/
public class DeviceShowDaoImpl implements DeviceShowDao {
	@Override
	public void addDeviceShow(DeviceShow deviceShow) {
		String sql="insert into t_device_show values(null,?)";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,deviceShow.getName());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void deleteDeviceShow(int id) {
		String sql="delete from t_device_show  where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void updateDeviceShow(DeviceShow deviceShow) {
		String sql="update t_device_show set name=? where id= ?";
		try{
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			runner.update(sql,deviceShow.getName(),deviceShow.getId());
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public List<DeviceShow> selectDeviceShowList() {
		try {
			String sql="select * from t_device_show";
			QueryRunner runner=new QueryRunner(TransactionManager.getSource());
			return runner.query(sql, new BeanListHandler<DeviceShow>(DeviceShow.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}


