package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ramyunmoa.web.entity.review.Review;


public class MainService {

	public List<Review> getReviewList() throws ClassNotFoundException, SQLException {

		List<Review> reviewList = new ArrayList<Review>();

		String sql = "SELECT * FROM Review ORDER BY regdate DESC LIMIT 10";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Review review = new Review(
				rs.getInt("id"),
				rs.getInt("writerId"),
				rs.getString("title"),
				rs.getString("content"),
				rs.getInt("likes"),
				rs.getInt("hit"),
				rs.getDate("regdate")
				);
			reviewList.add(review);
		}

		rs.close();
		st.close();
		con.close();

		return reviewList;
	}
	
}
