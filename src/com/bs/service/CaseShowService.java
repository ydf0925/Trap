
package com.bs.service;

import java.util.List;

import com.bs.entity.CaseShow;
import com.bs.utils.PageUtil;


/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月16日 下午8:21:35 
* @version 1.0 
*/
public interface CaseShowService extends Service {
void addCaseShow(CaseShow caseshow);
	
	void deleteCaseShow(int id);

	void updateCaseShow(CaseShow caseshow);

	PageUtil<CaseShow> selectCaseShowList(int page,int pageSize);
	
	List<CaseShow> selectList();
}
