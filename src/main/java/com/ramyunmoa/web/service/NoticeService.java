package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ramyunmoa.web.entity.notice.Notice;
import com.ramyunmoa.web.view.notice.NoticeView;

public class NoticeService {

	public List<NoticeView> getNoticeList(String field, String query, int page) throws ClassNotFoundException, SQLException{
		
		List<NoticeView> list = new ArrayList<>();
		
		String sql = "SELECT * FROM NoticeView WHERE " + field +" LIKE ? ORDER BY regdate DESC LIMIT 10 OFFSET ?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, '%'+query+'%');
		st.setInt(2, (page-1)*10);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeView noticeView = new NoticeView(
					rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"),
					rs.getInt("HIT"),
					rs.getBoolean("PUB"),
					rs.getInt("CMTCOUNT"));
			
			list.add(noticeView);
		}
		
		rs.close();
		st.close();
		con.close();

		return list;
		
	}
	
	public List<NoticeView> getNoticePubList(String field, String query, int page) throws ClassNotFoundException, SQLException {
		
		List<NoticeView> list = new ArrayList<>();
		
		String sql = "SELECT * FROM NoticeView WHERE " + field +" LIKE ? AND pub = 1 ORDER BY regdate DESC LIMIT 10 OFFSET ?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, '%'+query+'%');
		st.setInt(2, (page-1)*10);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			NoticeView noticeView = new NoticeView(
					rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"),
					rs.getInt("HIT"),
					rs.getBoolean("PUB"),
					rs.getInt("CMTCOUNT"));
			
			list.add(noticeView);
		}
		
		rs.close();
		st.close();
		con.close();

		return list;
	}

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice = null;
		
		String sql2 = "UPDATE Notice SET hit=hit+1 WHERE id=?";
		String sql = "SELECT * FROM Notice WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		
		PreparedStatement st2 = con.prepareStatement(sql2);
		st2.setInt(1, id);

		int rs2 = st2.executeUpdate();

		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"), 
					rs.getInt("HIT"), 
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		st2.close();
		con.close();
		
//		System.out.println(notice);
		
		return notice;
	}

	public int insertNotice(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "INSERT INTO Notice(title, content, writerId, pub) VALUES(?, ?, ?, ?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setString(3, notice.getWriterId());
		st.setBoolean(4, notice.getPub());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	public int deleteNotice(int id) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "DELETE FROM Notice WHERE id=?";
		String sql2 = "DELETE FROM NoticeComment WHERE boardId=?";
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

	public int updateNotice(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql = "UPDATE Notice SET title=?, content=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public Notice getNextNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice = null;
		
		String sql = "SELECT * FROM Notice WHERE id = "
				+ "(SELECT id FROM Notice "
				+ "WHERE regdate > (SELECT regdate FROM Notice WHERE id = ?) LIMIT 1)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"), 
					rs.getInt("HIT"), 
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		con.close();
		
		
		return notice;
	}
	
	public Notice getPrevNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice = null;
		
		String sql = "SELECT * FROM (SELECT * FROM Notice ORDER BY regdate DESC) C "
				+ "WHERE regdate < (SELECT regdate FROM Notice WHERE id = ?) LIMIT 1";
		
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"), 
					rs.getInt("HIT"), 
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	
	public Notice getNextPubNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice = null;
		
		String sql = "SELECT * FROM Notice WHERE id = "
				+ "(SELECT id FROM Notice "
				+ "WHERE regdate > (SELECT regdate FROM Notice WHERE id = ? ) AND pub = 1 LIMIT 1)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"), 
					rs.getInt("HIT"), 
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		con.close();
		
		
		return notice;
	}
	
	public Notice getPrevPubNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice = null;
		
		String sql = "SELECT * FROM (SELECT * FROM Notice ORDER BY regdate DESC) C "
				+ "WHERE regdate < (SELECT regdate FROM Notice WHERE id = ?) AND pub = 1 LIMIT 1";
		
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), 
					rs.getString("TITLE"), 
					rs.getString("CONTENT"), 
					rs.getString("WRITERID"),
					rs.getDate("REGDATE"), 
					rs.getInt("HIT"), 
					rs.getBoolean("PUB"));
		}

		rs.close();
		st.close();
		con.close();
		
		return notice;
	}

	public int getNoticeCount() throws ClassNotFoundException, SQLException {
		
		return getNoticeCount("title", "");
	}
	
	public int getNoticeCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;
			
		String sql = "SELECT COUNT(id) count FROM "
				+ "(SELECT N.* FROM"
				+ "(SELECT *FROM Notice WHERE " + field + " LIKE ? ORDER BY regdate DESC) N) N2";
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
	
	public int pubNoticeAll(int[] oids, int[] cids) throws ClassNotFoundException, SQLException {
		
		List<String> odisList = new ArrayList<>();
		for(int i=0; i<oids.length; i++)
			odisList.add(String.valueOf(oids[i]));
		
		List<String> cdisList = new ArrayList<>();
		for(int i=0; i<cids.length; i++)
			cdisList.add(String.valueOf(cids[i]));
		
		return pubNoticeAll(odisList, cdisList);
	}
	
	public int pubNoticeAll(List<String> oids, List<String> cids) throws ClassNotFoundException, SQLException {
		
		String odisCSV = null;
		String cdisCSV = null;

		if(oids == null) {
			odisCSV = null;
			cdisCSV = String.join(",", cids);
		}
		else {
			odisCSV = String.join(",", oids);
			cdisCSV = String.join(",", cids);
		}
		
		return pubNoticeAll(odisCSV, cdisCSV);
	}
	
	public int pubNoticeAll(String oidsCSV, String cidsCSV) throws ClassNotFoundException, SQLException {

		int result = 0;
		
		if(oidsCSV == null)
			oidsCSV = null;
		System.out.printf("oidsCSV = %s\n", oidsCSV);
		
		if(cidsCSV.equals(""))
			cidsCSV = null;
		System.out.printf("cidsCSV = %s\n", cidsCSV);

		String sqlOpen = String.format("UPDATE Notice SET pub=1 WHERE id IN (%s)", oidsCSV);
		String sqlClose = String.format("UPDATE Notice SET pub=0 WHERE id IN (%s)", cidsCSV);
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		
		
		System.out.println(sqlOpen);
		System.out.println(sqlClose);
		
		Statement stOpen = con.createStatement();
		result += stOpen.executeUpdate(sqlOpen);
		
		Statement stClose = con.createStatement();
		result += stClose.executeUpdate(sqlClose);
		

		stClose.close();
		stOpen.close();
		
		
		con.close();
		
		return result;
	}

	public int deletNoticeAll(int[] ids) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String params = "";
		
		for(int i=0; i<ids.length;i++) {
			params += ids[i];
			
			if(i < ids.length-1)
				params += ",";
		}
		
		String sql2 = "DELETE FROM NoticeComment WHERE boardId IN ("+params+")";
		String sql = "DELETE FROM Notice WHERE id IN ("+params+")";
		
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