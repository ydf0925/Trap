
package com.bs.dao;

import java.util.List;

import com.bs.entity.CaseShow;



/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月14日 下午7:14:22 
* @version 1.0 
*/
public interface CaseShowDao extends Dao {
	
	void addCaseShow(CaseShow caseshow);
	
	void deleteCaseShow(int id);

	void updateCaseShow(CaseShow caseshow);

	List<CaseShow> selectCaseShowList();
}
