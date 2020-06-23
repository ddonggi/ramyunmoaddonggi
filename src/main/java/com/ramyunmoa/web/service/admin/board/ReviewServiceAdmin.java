package com.ramyunmoa.web.service.admin.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;
import com.ramyunmoa.web.entity.admin.board.ReportAdmin;

public class ReviewServiceAdmin {

	// --------------------------------------- notice
	// ---------------------------------------

	public List<BoardAdmin> getReviewNoticeList(String startDate, String endDate, String field, String searchName,
			int page) throws SQLException, ClassNotFoundException {

		List<BoardAdmin> list = new ArrayList<BoardAdmin>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewBoardNotice WHERE regdate > ? AND regdate < ? AND " + field
				+ " LIKE ? ORDER BY regdate DESC LIMIT ?, 10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ps.setInt(4, (page - 1) * 10);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			BoardAdmin board = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getInt("likes"), rs.getInt("hit"), rs.getDate("regdate"), rs.getInt("pub"),
					rs.getString("writerId"));

			list.add(board);
		}
		return list;
	}

	public int getReviewNoticeCount(String startDate, String endDate, String field, String searchName)
			throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM ReviewBoardNoticeView WHERE regdate > ? AND regdate < ? AND " + field
				+ " LIKE ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			count = rs.getInt("count");

		}

		return count;
	}

	public BoardAdmin getReviewNotice(int id) throws ClassNotFoundException, SQLException {

		BoardAdmin notice = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewBoardNoticeView WHERE id = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			notice = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getInt("likes"),
					rs.getInt("hit"), rs.getDate("regdate"), rs.getInt("pub"), rs.getString("nickname"));

		}
		return notice;
	}

	public void delNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "DELETE FROM ReviewBoardNotice WHERE id IN ( " + param + " )";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.executeUpdate();

	}

	public void pubNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "UPDATE ReviewBoardNoticeView SET PUB = 1 WHERE ID IN ( " + param + " )";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.executeUpdate();

	}

	public void insertAdminNotice(String writerId, String title, String content, String regdate)
			throws ClassNotFoundException, SQLException {

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "INSERT INTO ReviewBoardNotice(writerId, title, content) VALUES(?, ?, ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, writerId);
		ps.setString(2, title);
		ps.setString(3, content);
		ps.executeUpdate();

	}

	// --------------------------------------- review
	// ---------------------------------------

	public List<BoardAdmin> getReviewAdminList(String startDate, String endDate, String field, String searchName,
			int page) throws SQLException, ClassNotFoundException {

		List<BoardAdmin> list = new ArrayList<BoardAdmin>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewDetailView WHERE regdate > ? AND regdate < ? AND " + field
				+ " LIKE ? ORDER BY regdate DESC LIMIT ?, 10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ps.setInt(4, (page - 1) * 10);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			BoardAdmin board = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getInt("likes"), rs.getInt("hit"), rs.getDate("regdate"), rs.getString("writerName"));

			list.add(board);
		}
		return list;
	}

	public int getReviewAdminCount(String startDate, String endDate, String field, String searchName)
			throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM ReviewDetailView WHERE regdate > ? AND regdate < ? AND " + field
				+ " LIKE ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			count = rs.getInt("count");

		}

		return count;
	}

	public BoardAdmin getReviewAdmin(int id) throws ClassNotFoundException, SQLException {

		BoardAdmin notice = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewDetailView WHERE id = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			notice = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getInt("likes"),
					rs.getInt("hit"), rs.getDate("regdate"), rs.getString("writerName"));

		}
		return notice;
	}

	public void delReviewAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "DELETE FROM Review WHERE id IN ( " + param + " )";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.executeUpdate();

	}

	// --------------------------------------- report
	// ---------------------------------------

	public List<ReportAdmin> getReportAdminList(String startDate, String endDate, String field, String searchName,
			int page) throws SQLException, ClassNotFoundException {

		List<ReportAdmin> list = new ArrayList<ReportAdmin>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewReportView WHERE reportRegdate > ? AND reportRegdate < ? AND " + field
				+ " LIKE ? ORDER BY reportRegdate DESC LIMIT ?, 10";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ps.setInt(4, (page - 1) * 10);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ReportAdmin board = new ReportAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getString("nickname"), rs.getDate("regdate"), rs.getInt("hit"), rs.getString("reportId"),
					rs.getString("reportTitle"), rs.getString("reportContent"), rs.getString("reportNickname"),
					rs.getDate("reportRegdate"));

			list.add(board);
		}
		return list;
	}

	public int getReportAdminCount(String startDate, String endDate, String field, String searchName)
			throws ClassNotFoundException, SQLException {

		int count = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(reportId) count FROM ReviewReportView WHERE reportRegdate > ? AND reportRegdate < ? AND "
				+ field + " LIKE ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ps.setString(3, '%' + searchName + '%');
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			count = rs.getInt("count");

		}

		return count;
	}

	public ReportAdmin getReportAdmin(int id) throws ClassNotFoundException, SQLException {

		ReportAdmin notice = null;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewReportView WHERE reportId = ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			notice = new ReportAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getString("nickname"), rs.getDate("regdate"), rs.getInt("hit"), rs.getString("reportId"),
					rs.getString("reportTitle"), rs.getString("reportContent"), rs.getString("reportNickname"),
					rs.getDate("reportRegdate"));

		}
		return notice;
	}

	public void delReportAll(int[] ids) throws ClassNotFoundException, SQLException {

		String param = "";
		for (int i = 0; i < ids.length; i++) {
			param += ids[i];
			if (i < ids.length - 1) {
				param += ", ";
			}
		}

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "DELETE FROM ReviewReportView WHERE reportId IN ( " + param + " )";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.executeUpdate();

	}

//	---------------------------------------------------------------------------------------------------

	public int countReview(String startDate, String endDate) throws ClassNotFoundException, SQLException {

		int cr = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM Review WHERE regdate BETWEEN ? AND ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			cr = rs.getInt("count");

		}
		return cr;
	}

	public int countReviewCmt(String startDate, String endDate) throws ClassNotFoundException, SQLException {

		int crc = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM ReviewCmt WHERE regdate BETWEEN ? AND ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			crc = rs.getInt("count");

		}
		return crc;
	}

	public int countReviewReport(String startDate, String endDate) throws ClassNotFoundException, SQLException {

		int crr = 0;

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT count(id) count FROM ReviewReport WHERE regdate BETWEEN ? AND ?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			crr = rs.getInt("count");

		}
		return crr;
	}

	public List<BoardAdmin> rankingReview(String startDate, String endDate)
			throws ClassNotFoundException, SQLException {

		List<BoardAdmin> list = new ArrayList<BoardAdmin>();

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		String sql = "SELECT * FROM ReviewDetailView WHERE regdate > ? AND regdate < ? order by hit DESC LIMIT 3";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, startDate);
		ps.setString(2, endDate);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			BoardAdmin board = new BoardAdmin(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
					rs.getInt("likes"), rs.getInt("hit"), rs.getDate("regdate"), rs.getString("writerName"));

			list.add(board);
		}
		return list;

	}

}
