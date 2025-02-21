package com.echolink.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class RandomID {
	private static final Random rand=new Random();
	public static long generateUserID(Connection con) throws Exception  {
		long userid = 0;
		boolean isUnique=false;
		while(!isUnique) {
			 userid = 10000000L + (long) (rand.nextDouble() * 90000000L);
			 String checkQuery="SELECT COUNT(*) FROM users WHERE id=?";
			 try(PreparedStatement st=con.prepareStatement(checkQuery)){
				 st.setLong(1, userid);
				 ResultSet rs=st.executeQuery();
				 if(rs.next() && rs.getInt(1)==0) {
					 isUnique=true;
				 }
			 }
		
					 
			 
		}
		return userid;
	}
}
