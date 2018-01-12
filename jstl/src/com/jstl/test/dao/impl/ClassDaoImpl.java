package com.jstl.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jstl.test.common.DBCon;
import com.jstl.test.dao.ClassDao;
import com.jstl.test.vo.ClassInfo;

public class ClassDaoImpl implements ClassDao{

	@Override
	public List<ClassInfo> getClassList() {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<ClassInfo> classList = new ArrayList<ClassInfo>();
		
		
		try {
			con = DBCon.getCon();
			String sql = "select * from class_info";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ClassInfo ci = new ClassInfo();
				ci.setCino(rs.getInt("cino"));
				ci.setCiname(rs.getString("ciname"));
				ci.setCidesc(rs.getString("cidesc"));
				classList.add(ci);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classList;
	}

}
