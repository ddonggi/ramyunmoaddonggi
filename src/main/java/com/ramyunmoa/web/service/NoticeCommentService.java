package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.notice.NoticeComment;
import com.ramyunmoa.web.view.notice.NoticeCommentView;

public class NoticeCommentService {
	
	public List<NoticeCommentView> getNoticeComment(Integer id) throws ClassNotFoundException, SQLException{
		
		List<NoticeCommentView> list = new ArrayList<>();
		
		String sql = "SELECT * FROM NoticeComment WHERE boardId = ? ORDER BY regdate DESC";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeCommentView commentView = new NoticeCommentView(
					rs.getInt("ID"),
					rs.getString("CONTENT"),
					rs.getString("WRITERID"),
					rs.getString("REGDATE"));
			
			list.add(commentView);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public int insertComment(NoticeComment comment) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO NoticeComment(writerId, content, boardId) VALUES(?, ?, ?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, comment.getWriterId());
		st.setString(2, comment.getContent());
		st.setInt(3, comment.getBoardId());
		
//		System.out.println(comment.getContent());
//		System.out.println(comment.getBoardId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int deleteNoticeComment(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "DELETE FROM NoticeComment WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}
}
