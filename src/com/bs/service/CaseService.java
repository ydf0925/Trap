
package com.bs.service;

import java.util.List;

import com.bs.entity.Case;
import com.bs.utils.PageUtil;

/** 
* @author 作者 :yuedengfeng
* @date 创建时间：2019年9月17日 下午3:20:01 
* @version 1.0 
*/
public interface CaseService extends Service{
	void addCase(Case cases);
	
	void deleteCase(int id);

	void updateCase(Case cases);
	
	void updateImg(Case cases);
	

	PageUtil<Case> selectCaseList(int page,int pageSize);
	
	List<Case> selectByCid(int cid);
	
	Case selectById(int id);
	PageUtil<Case> selectCaseImgList(int page,int pageSize);
}
