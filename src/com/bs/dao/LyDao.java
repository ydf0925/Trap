
package com.bs.dao;

import java.util.List;

import com.bs.entity.Ly;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月15日 上午7:34:48 
* @version 1.0 
*/
public interface LyDao extends Dao{
	void addLy(Ly ly);
	
	List<Ly> selectLyList();
}
