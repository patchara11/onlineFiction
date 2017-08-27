package edu.bc.model;

import edu.bc.bean.Member;
import edu.bc.dao.RegisterDao;

public class RegisterModel {

	public Member validateUser(Member membook){
		RegisterDao register = new RegisterDao();
		Member beforeuser = register.find(membook);
		return beforeuser;
		
	}
	
}
