package com.techthinker.CAWeb.idao;

import java.util.List;

import com.techthinker.CAWeb.persistence.Major;

public interface IMajorDao extends IBaseDao<Major> {

	public void addMajorList(List<Major> Major);
}
