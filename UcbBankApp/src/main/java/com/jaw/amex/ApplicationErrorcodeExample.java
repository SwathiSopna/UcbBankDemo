package com.jaw.amex;

import java.util.List;

import org.assertj.core.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jaw.UcbBankApp.exception.DuplicateUserIdEntryException;

public class ApplicationErrorcodeExample {
	
	public static void main(String[] a) throws DuplicateUserIdEntryException {
		
	      String str = "{\"errorCode\" : 930,\"developerMessage\" : \"SCRA is enrolled\", \"userMessage\" : \"Product Transfer \"}";
			
			JsonObject g = new Gson().fromJson(str,JsonObject.class);	
			String error = g.get("errorCode").toString();
			String develop = g.get("developerMessage").toString();
			System.out.println("ssfs"+ error + develop);
			//ApplicationClass app = g.fromJson(str,ApplicationClass.class);
			
			
			if( error.equals("930") ) {
				 
				
			
			throw new DuplicateUserIdEntryException("developerMessage : "+develop + " errorCode : " +error);
			}
			else {
				throw new DuplicateUserIdEntryException("OOPS! went wrong");
			}
			
		}

	private static String convertWithComma(String string, ApplicationClass app) {
		String error = app.getErrorCode();
		String develop = app.getDeveloperMessage();
		/*List<String> listString = new ArrayList<String>() {{
			add(new String ("error",app.getErrorCode()))
		}}*/
		
		
		return String.join(string, app.getDeveloperMessage(),app.getErrorCode());
		
		// TODO Auto-generated method stub
		
	}

}
