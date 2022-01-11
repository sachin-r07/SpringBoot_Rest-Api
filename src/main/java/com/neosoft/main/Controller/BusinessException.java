package com.neosoft.main.Controller;

public class BusinessException extends Exception 
{

	public Object getErrorCode() 
	{
		
		return 204;
	}

	public Object getErrorMessage() 
	{
		
		return "User not Found";
	}

}
