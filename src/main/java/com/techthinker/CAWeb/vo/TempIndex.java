package com.techthinker.CAWeb.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.techthinker.CAWeb.util.IndexUtil;

@Entity
@Table(name="tempindex", catalog = "campusassistant_web")
public class TempIndex {
	
	private int tempindex_id;
	private int objId;
	private String objType;//Message,Attachment
	private int operator;

	/**
	 * @return the tempindex_id
	 */
	@Id
	@GeneratedValue
	public int getTempindex_id() {
		return tempindex_id;
	}
	/**
	 * @param tempindex_id the tempindex_id to set
	 */
	public void setTempindex_id(int tempindex_id) {
		this.tempindex_id = tempindex_id;
	}
	
	/**
	 * 要操作的对象id，可能是user,college,major,grade,campusnews,question,scenicspot,intent
	 * @return
	 */
	@Column(name="obj_id")
	public int getObjId() {
		return objId;
	}
	public void setObjId(int objId) {
		this.objId = objId;
	}
	/**
	 * 需要操作的对象类型，可能是user,college,major,grade,campusnews,question,scenicspot,intent
	 * @return
	 */
	@Column(name="obj_type")
	public String getObjType() {
		return objType;
	}
	public void setObjType(String objType) {
		this.objType = objType;
	}
	/**
	 * 操作的类型是Add还是Delete或者Update
	 * @return
	 */
	@Column(name="operator")
	public int getOperator() {
		return operator;
	}
	public void setOperator(int operator) {
		this.operator = operator;
	}

	public void setDelete() {
		operator = IndexUtil.OP_DEL;
	}
	
	public void setAdd() {
		operator = IndexUtil.OP_ADD;
	}
	
	public void setUpdate() {
		operator = IndexUtil.OP_UPDATE;
	}
}
