package com.techthinker.CAWeb.iwebservice;

import javax.jws.WebParam;
import javax.jws.WebResult;

import com.techthinker.CAWeb.persistence.User;

public interface IHelloWorld {
    @WebResult(name = "sayHelloReturn")
	public String sayHello(@WebParam(name = "name")String name,@WebParam(name = "contentStr")String contentStr) ;
    @WebResult(name = "registerReturn")
	public boolean register(@WebParam(name = "user")User user) ;
}
