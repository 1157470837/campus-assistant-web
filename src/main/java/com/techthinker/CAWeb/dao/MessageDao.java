package com.techthinker.CAWeb.dao;


import org.springframework.stereotype.Repository;

import com.techthinker.CAWeb.idao.IMessageDao;
import com.techthinker.CAWeb.persistence.Message;

@Repository("messageDao")
public class MessageDao extends BaseDao<Message> implements IMessageDao {


}
