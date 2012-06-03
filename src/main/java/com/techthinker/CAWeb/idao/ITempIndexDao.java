package com.techthinker.CAWeb.idao;

import com.techthinker.CAWeb.persistence.TempIndex;

public interface ITempIndexDao extends IBaseDao<TempIndex> {
	public void delAll();
}
