package com.techthinker.CAWeb.vo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "campusassistant_web")
public class Message implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6432912418392666212L;
	private Integer messageId;
	private User userByUserId;
	private User userByTouserId;
	private Chatroom chatroom;
	private String content;
	private Timestamp pubdate;
	private Integer totype;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(String content, Timestamp pubdate, Integer totype) {
		this.content = content;
		this.pubdate = pubdate;
		this.totype = totype;
	}

	/** full constructor */
	public Message(User userByUserId, User userByTouserId, Chatroom chatroom,
			String content, Timestamp pubdate, Integer totype) {
		this.userByUserId = userByUserId;
		this.userByTouserId = userByTouserId;
		this.chatroom = chatroom;
		this.content = content;
		this.pubdate = pubdate;
		this.totype = totype;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUserByUserId() {
		return this.userByUserId;
	}

	public void setUserByUserId(User userByUserId) {
		this.userByUserId = userByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "touser_id")
	public User getUserByTouserId() {
		return this.userByTouserId;
	}

	public void setUserByTouserId(User userByTouserId) {
		this.userByTouserId = userByTouserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tochatroom_id")
	public Chatroom getChatroom() {
		return this.chatroom;
	}

	public void setChatroom(Chatroom chatroom) {
		this.chatroom = chatroom;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "pubdate", nullable = false, length = 19)
	public Timestamp getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Timestamp pubdate) {
		this.pubdate = pubdate;
	}

	@Column(name = "totype", nullable = false)
	public Integer getTotype() {
		return this.totype;
	}

	public void setTotype(Integer totype) {
		this.totype = totype;
	}

}