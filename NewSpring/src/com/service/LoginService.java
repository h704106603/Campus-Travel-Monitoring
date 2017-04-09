package com.service;

public interface LoginService {

	boolean isAdmin(String id,String password);
	
	boolean Register(String username,String password,String email,String classroom);
	
}
