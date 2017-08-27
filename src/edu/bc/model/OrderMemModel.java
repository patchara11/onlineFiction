package edu.bc.model;

import edu.bc.bean.Member;
import edu.bc.dao.OrderDao;

public class OrderMemModel {
	public Member passData(Member mem){
		OrderDao orderSession = new OrderDao();
		Member Membermem = orderSession.getData(mem);
		return Membermem;
		
		
	}

}
