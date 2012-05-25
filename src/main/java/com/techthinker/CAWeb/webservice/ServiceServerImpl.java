package com.techthinker.CAWeb.webservice;

import org.springframework.stereotype.Component;

import com.techthinker.CAWeb.iwebservice.IServiceServer;

@Component("SayHelloService")
public class ServiceServerImpl implements IServiceServer {
	@Override
	public String sayhello(String name) {
		return "my name is " + name;
	}
}