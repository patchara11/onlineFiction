/**
 * This class is used to get Data from DB.
 */
package com.data;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Vikas Verma
 */
public class JasperData {
	public static List getData(){
		List<JasperDataBean> datalist= new ArrayList<JasperDataBean>(0);	
		datalist.add(new JasperDataBean("abcd", "abcd@abcd.com", "www.abcd.abcd", "this is subject", "this is message", "A", "2013-07-06"));
		datalist.add(new JasperDataBean("arm", "arm@abcd.com", "www.arm.abcd", "this is subject", "this is message", "A", "2013-07-06"));
		datalist.add(new JasperDataBean("nammon", "nammon@abcd.com", "www.nammon.abcd", "this is subject", "this is message", "A", "2013-07-06"));
		
    return datalist;
  }
}
