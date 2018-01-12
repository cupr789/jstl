package com.jstl.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jstl.test.common.DBCon;
import com.jstl.test.dao.UserDao;
import com.jstl.test.vo.UserClass;

public class UserDaoImpl implements UserDao{
	
	@Override
	public List<UserClass> getUserList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<UserClass> list = new ArrayList<UserClass>();
		try {
			con =DBCon.getCon();
			String sql = "select * from user_info";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()) {
				UserClass uc = new UserClass();
				uc.setCiNo(rs.getInt("cino"));
				uc.setUiNo(rs.getInt("uino"));
				uc.setAddress(rs.getString("address"));
				uc.setUiAge(rs.getInt("uiage"));
				uc.setUiName(rs.getString("uiname"));
				uc.setUiId(rs.getString("uiid"));
				uc.setUiPwd(rs.getString("uipwd"));
				uc.setUiRegdate(rs.getString("uiregdate"));
				list.add(uc);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			
			try {
				if(rs!=null) {
					rs.close();					
				}
				if(ps!=null) {					
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
