package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.notice.Feedback;
import com.ramyunmoa.web.view.notice.FeedbackView;

public class FeedbackService {

	public List<FeedbackView> getFeedbackList(String field, String query, int page) throws ClassNotFoundException, SQLException {

		List<FeedbackView> list = new ArrayList<>();
		
		String sql = "SELECT * FROM FeedbackView WHERE " + field +" LIKE ? ORDER BY regdate DESC LIMIT 10 OFFSET ?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, '%'+query+'%');
		st.setInt(2, (page-1)*10);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			FeedbackView feedbackView = new FeedbackView(
					rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("WRITERID"),
					rs.getString("REGDATE"),
					rs.getInt("HIT"),
					rs.getInt("CMTCOUNT"));
		
			list.add(feedbackView);
		
		}
		
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	public Feedback getFeedback(Integer id) throws ClassNotFoundException, SQLException {

		Feedback feedback = null;
		
		String sql2 = "UPDATE Feedback SET hit=hit+1 WHERE id=?";
		String sql = "SELECT * FROM Feedback WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setInt(1, id);
		
		int rs2 = st2.executeUpdate();
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			feedback = new Feedback(
					rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getString("REGDATE"), 
					rs.getInt("HIT"));
		}
		
		rs.close();
		st.close();
		st2.close();
		con.close();
		
		return feedback;
	}

	public int insertFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO Feedback(title, content, writerId) VALUES(?, ?, ?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, feedback.getTitle());
		st.setString(2, feedback.getContent());
		st.setString(3, feedback.getWriterId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int deleteNotice(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql2 = "DELETE FROM FeedbackComment WHERE boardId=?";
		String sql = "DELETE FROM Feedback WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		
		PreparedStatement st2 = con.prepareStatement(sql2);
		PreparedStatement st = con.prepareStatement(sql);
		
		st2.setInt(1, id);
		st.setInt(1, id);
		
		int rs2 = st2.executeUpdate();
		result = st.executeUpdate();
		
		st.close();
		st2.close();
		con.close();
		
		return result;
	}

	public int updateFeedback(Feedback feedback) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "UPDATE Feedback SET title=?, content=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, feedback.getTitle());
		st.setString(2, feedback.getContent());
		st.setInt(3, feedback.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
		
	}

	public Feedback getNextFeedback(int id) throws ClassNotFoundException, SQLException {
		
		Feedback feedback = null;
		
		String sql = "SELECT * FROM Feedback WHERE id = "
				+ "(SELECT id FROM Feedback "
				+ "WHERE regdate > (SELECT regdate FROM Feedback WHERE id = ?) LIMIT 1)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			feedback = new Feedback(
					rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getString("REGDATE"), 
					rs.getInt("HIT"));
		}

		rs.close();
		st.close();
		con.close();
		
		
		return feedback;
	}
	
	public Feedback getPrevFeedback(int id) throws ClassNotFoundException, SQLException {
		
		Feedback feedback = null;
		
		String sql = "SELECT * FROM (SELECT * FROM Feedback ORDER BY regdate DESC) C "
				+ "WHERE regdate < (SELECT regdate FROM Feedback WHERE id = ?) LIMIT 1";
		
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			feedback = new Feedback(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getString("REGDATE"), 
					rs.getInt("HIT"));
		}

		rs.close();
		st.close();
		con.close();
		
		return feedback;
	}
	
	public int getFeedbackCount() throws ClassNotFoundException, SQLException {
		
		return getFeedbackCount("title", "");
	}
	
	public int getFeedbackCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;
			
		String sql = "SELECT COUNT(id) count FROM "
				+ "(SELECT F.* FROM"
				+ "(SELECT *FROM Feedback WHERE " + field + " LIKE ? ORDER BY regdate DESC) F) F2";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, '%'+query+'%');
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next())
			count = rs.getInt("count");
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}

	public int deletNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String params = "";
		
		for(int i=0; i<ids.length;i++) {
			params += ids[i];
			
			if(i < ids.length-1)
				params += ",";
		}
		
		String sql2 = "DELETE FROM FeedbackComment WHERE boardId IN ("+params+")";
		String sql = "DELETE FROM Feedback WHERE id IN ("+params+")";
		
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		PreparedStatement st2 = con.prepareStatement(sql2);
		
		int rs2 = st2.executeUpdate();
		result = st.executeUpdate();
		
		

		st.close();
		con.close();
		
		return result;
	}
}
