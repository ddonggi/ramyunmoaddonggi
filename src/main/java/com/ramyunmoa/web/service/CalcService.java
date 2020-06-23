package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.view.product.NutritionView;
import com.ramyunmoa.web.view.product.ProductView;

public class CalcService {
	
	
	public List<ProductView> getProdList() throws SQLException, ClassNotFoundException {

		List<ProductView> prodList = new ArrayList<ProductView>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM rmteam.ProductView ORDER BY mfr";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs = pt.executeQuery();

		while (rs.next()) {
			ProductView product = new ProductView(
					rs.getInt("id"), 
					rs.getString("name"),
					rs.getInt("kcal"),
					rs.getString("mfr"));
			prodList.add(product);
		}

		rs.close();
		pt.close();
		con.close();

		return prodList;
	}
}
