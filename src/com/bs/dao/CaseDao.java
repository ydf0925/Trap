
package com.bs.dao;

import java.util.List;

import com.bs.entity.Case;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午2:58:20 
* @version 1.0 
*/
public interface CaseDao extends Dao {
	void addCase(Case cases);
	
	void deleteCase(int id);

	void updateCase(Case cases);
	
	void updateImg(Case cases);
	
	List<Case> selectCaseList();
	
	List<Case> selectByCid(int cid);
	
	Case selectById(int id);
	List<Case> selectCaseImgList();
}
