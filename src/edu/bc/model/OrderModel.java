package edu.bc.model;

import java.util.ArrayList;

import edu.bc.bean.Member;
import edu.bc.bean.Order;
import edu.bc.dao.LoginDao;
import edu.bc.dao.OrderDao;
public class OrderModel {
		public ArrayList memberData(String[] ids,Member member,ArrayList orders){
		OrderDao memberOrder = new OrderDao();
		ArrayList bookorder = memberOrder.find(ids,member,orders);
		return bookorder;
		
		
	}

	}
