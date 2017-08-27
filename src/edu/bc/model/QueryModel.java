package edu.bc.model;

import java.util.ArrayList;

import edu.bc.bean.Book;
import edu.bc.dao.QueryDao;

public class QueryModel {
	public ArrayList select(String[] book){
		QueryDao query = new QueryDao();
		ArrayList order = query.find(book);
		return order;
		
	}
}
