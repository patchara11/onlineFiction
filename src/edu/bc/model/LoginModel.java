package edu.bc.model;

import edu.bc.bean.Member;
import edu.bc.dao.LoginDao;

public class LoginModel {
	public Member validateUser(Member member){
		LoginDao login = new LoginDao();
		Member user = login.find(member);
		return user;
		
	}
}
