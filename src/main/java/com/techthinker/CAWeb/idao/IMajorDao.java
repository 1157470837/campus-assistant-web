package com.techthinker.CAWeb.idao;

import java.util.List;

import com.techthinker.CAWeb.vo.Major;

public interface IMajorDao extends IBaseDao<Major> {

	public void addMajorList(List<Major> Major);
}
