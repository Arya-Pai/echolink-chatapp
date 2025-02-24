package com.echolink.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.echolink.model.RandomID;
import com.echolink.model.User;
import com.echolink.util.DBUtil;

public class UserDAO {
	public boolean validate(String email,String password) throws ClassNotFoundException, SQLException{
		boolean status =false;
		try(Connection con=DBUtil.getConnection();
			PreparedStatement st=con.prepareStatement("SELECT *  FROM users WHERE email=? AND password=?")){
				st.setString(1, email);
				st.setString(2, password);
				ResultSet res=st.executeQuery();
				status=res.next();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean register(User user) throws SQLException, ClassNotFoundException {
		boolean status=false;
		try(Connection con=DBUtil.getConnection();
			PreparedStatement st=con.prepareStatement("INSERT INTO users(id,username,email,password) VALUES(?,?,?,?)")){
			long userid=RandomID.generateUserID(con);
			st.setLong(1, userid);
			st.setString(2, user.getUsername());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());
			int rows=st.executeUpdate();
			status=rows>0;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public User getUserByEmailAndPassword(String email,String Password) throws ClassNotFoundException, SQLException {
		try(Connection con=DBUtil.getConnection();
			PreparedStatement st=con.prepareStatement("SELECT id, username FROM users WHERE email = ? AND password = ?")){
				st.setString(1, email);
				st.setString(2, Password);
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					return new User(rs.getLong("id"),rs.getString("username"));
				}
		}
		return null;
	}
}
