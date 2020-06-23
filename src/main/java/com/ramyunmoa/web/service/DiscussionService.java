package com.ramyunmoa.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ramyunmoa.web.entity.discussion.Discussion;
import com.ramyunmoa.web.entity.discussion.DiscussionCmt;
import com.ramyunmoa.web.entity.discussion.Topic;
import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.entity.review.ReviewCmt;
import com.ramyunmoa.web.view.review.DiscussionDetailView;
import com.ramyunmoa.web.view.review.DiscussionListView;
import com.ramyunmoa.web.view.review.MfcProductView;
import com.ramyunmoa.web.view.review.ReviewDetailView;

public class DiscussionService {

	/*
	 * // 전체조회 public List<Review> getReviewList() throws ClassNotFoundException,
	 * SQLException {
	 * 
	 * List<Review> list = new ArrayList<Review>();
	 * 
	 * String sql = "SELECT * FROM Review"; String url =
	 * "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	 * 
	 * Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
	 * DriverManager.getConnection(url, "rmteam", "rm0322"); PreparedStatement st =
	 * con.prepareStatement(sql); ResultSet rs = st.executeQuery();
	 * 
	 * while (rs.next()) { Review review = new Review(rs.getInt("id"),
	 * rs.getString("item"), rs.getString("star"), rs.getString("regdate"),
	 * rs.getString("writerName"), rs.getString("title"), rs.getInt("comment"));
	 * list.add(review); }
	 * 
	 * rs.close(); st.close(); con.close();
	 * 
	 * return list; }
	 */

	// 자세한 페이지 조회
	/*
	public DiscussionDetailView getDiscussionDetailView(int id) throws ClassNotFoundException, SQLException {
		ReviewDetailView rdv = null;

		String sql = "SELECT * FROM ReviewDetailView WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			id = rs.getInt("id");
			String title = rs.getString("title");
			String mfcProduct = rs.getString("mfc-product");
			Date regdate = rs.getDate("regdate");
			String writerName = rs.getString("writerName");
			int hit = rs.getInt("hit");
			int likes = rs.getInt("likes");
			String content = rs.getString("content");
			int gradeId = rs.getInt("gradeId");
			String gdContent = rs.getString("gdContent");
			int cmtCount = rs.getInt("cmtCount");

			rdv = new ReviewDetailView(id, title, mfcProduct, regdate, writerName, hit, likes, content, gradeId,
					gdContent, cmtCount);

		}

		rs.close();
		st.close();
		con.close();

		return rdv;
	}*/

	// 리뷰게시판 글 등록
	public int insertDiscussion(Discussion dis) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "INSERT INTO Discussion(title,content,writerId,topicId) VALUES(?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, dis.getTitle());
		st.setString(2, dis.getContent());
		st.setInt(3, dis.getWriterId());
		st.setInt(4, dis.getTopicId());

		result = st.executeUpdate();

//		rs.close();
		st.close();
		con.close();

		return result;
	}

	// 자세한 페이지 수정
	public int updateDiscussion(Discussion dis) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE Discussion SET title=?,content=?,topicId=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는
//	  드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, dis.getTitle());
		st.setString(2, dis.getContent());
		st.setInt(3, dis.getTopicId());
		st.setInt(4, dis.getId());

		result = st.executeUpdate();

		// rs.close(); st.close(); con.close();

		return result;
	}

	
	  // 자세한페이지 삭제 
	public int deleteDiscussion(int id) throws ClassNotFoundException, SQLException {
	  
	  int result = 0;
	  
	  String sql = "DELETE FROM Discussion WHERE id=?"; 
	  String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	  
	  Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는
	  //드라이버 클래스가 달라져야함 
	  Connection con = DriverManager.getConnection(url, "rmteam",
	  "rm0322"); PreparedStatement st = con.prepareStatement(sql);
	  
	  st.setInt(1, id);
	  
	  result = st.executeUpdate();
	  
	  // rs.close(); st.close(); con.close();
	  
	  return result; }
	 

	// 리뷰 목록 검색
	public List<DiscussionListView> getDiscussionListView(String field, String query, int page)
			throws ClassNotFoundException, SQLException {
		List<DiscussionListView> list = new ArrayList<DiscussionListView>();

		String sql = "SELECT * FROM DiscussionListView " + " WHERE " + field
				+ " LIKE ? ORDER BY regdate DESC LIMIT 10 OFFSET ?";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, "%" + query + "%");
		st.setInt(2, (page - 1) * 10); // 1->0,2->10,3->20,30,40...
		// st.setInt(2, (page-1)*10);
//		st.setInt(2, page*10-1);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			DiscussionListView review = new DiscussionListView(rs.getInt("id"), rs.getInt("writerId"),
					rs.getString("title"), rs.getString("nickname"),
					rs.getDate("regdate"), rs.getInt("cmtCount"),rs.getString("content"),rs.getString("topic"),rs.getInt("topicId"),rs.getInt("likes"),rs.getInt("hit"));
			list.add(review);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	// 리뷰 게시판 글 갯수
	public int getDiscussionCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;

		String sql = "SELECT COUNT(ID) COUNT FROM DiscussionListView " + " WHERE " + field
				+ " LIKE ? ORDER BY regdate DESC";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, "%" + query + "%");

		ResultSet rs = st.executeQuery();
		if (rs.next())
			count = rs.getInt("count");

		rs.close();
		st.close();
		con.close();

		return count;

	}

	// 자세한 페이지 댓글등록
	public DiscussionCmt insertCmt(DiscussionCmt cmt) throws SQLException, ClassNotFoundException {

		int result = 0;
		DiscussionCmt cmt2 = null;
		String sql = "";
		boolean flag = false;

		if (cmt.getBossId() == -1) { // 대댓글이 아니라면
			sql = "INSERT INTO DiscussionCmt(writerName, content,discussionId) VALUES(?,?,?)";
		} else { // 대댓글이면
			sql = "INSERT INTO DiscussionCmt(writerName, content,discussionId,bossId) VALUES(?,?,?,?)";
			flag = true;
		}

		String sql2 = "SELECT * FROM DiscussionCmt WHERE writerName=? ORDER BY REGDATE DESC LIMIT 1"; // 최근 데이터 하나만 추출

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs2 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "rmteam", "rm0322");

			con.setAutoCommit(false);

			st = con.prepareStatement(sql); // INSERT sql

			System.out.println(cmt.getBossId());

			if (flag) { // 대댓글이라면
				st.setInt(4, cmt.getBossId());
			}
			st.setString(1, cmt.getWriterName());
			st.setString(2, cmt.getContent());
			st.setInt(3, cmt.getDiscussionId());

			System.out.println("rs2222222222222:");
			result = st.executeUpdate();

			st2 = con.prepareStatement(sql2);
			st2.setString(1, cmt.getWriterName());

			System.out.println("rs2222:");

			rs2 = st2.executeQuery();

			System.out.println("rs2:");
			System.out.println(rs2);
			if (rs2.next()) {
				cmt2 = new DiscussionCmt();
				cmt2.setId(rs2.getInt("id"));
				cmt2.setWriterName(rs2.getString("writerName"));
				cmt2.setRegdate(rs2.getDate("regDate"));
				cmt2.setContent(rs2.getString("content"));
				cmt2.setBossId(rs2.getInt("bossId"));
			}

			con.commit(); // 수동적인(manual) commit

			st.close();
			rs2.close();
			st2.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ClassNotFoundException(); // UI가 처리하라는 예외메시지를 던진다.
		} catch (SQLException e) {

			try {
				if (con != null)
					con.rollback();

				if (st != null)
					st.close();

				rs2.close(); // commit이 제대로 되지 않았을 때도 닫아줘야함
				st2.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new SQLException();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return cmt2;
	}

	// 제조사-라면 목록 whghl
	public List<MfcProductView> getMfcProductViewList() throws ClassNotFoundException, SQLException {
		List<MfcProductView> list = new ArrayList<MfcProductView>();

		String sql = "SELECT * FROM MfcProductView ORDER BY id";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			MfcProductView view = new MfcProductView(rs.getInt("id"), rs.getString("mfcName"),
					rs.getString("productName"), rs.getString("mfc-product"), rs.getString("img"),
					rs.getString("logo"));
			list.add(view);
		}

		rs.close();
		st.close();
		con.close();

		return list;

	}

	// 평점 목록 조회
	public List<Grade> getGrade() throws ClassNotFoundException, SQLException {
		List<Grade> list = new ArrayList<Grade>();

		String sql = "SELECT * FROM Grade";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);

		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			Grade grade = new Grade(rs.getInt("id"), rs.getInt("value"), rs.getString("content"));
			list.add(grade);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	// 회원 정보 가져오기
	public Member getMember(String uid) throws SQLException, ClassNotFoundException {
		Member member = null;

		String sql = "SELECT * FROM Member WHERE uid=?";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
//		Statement st = con.createStatement();

		st.setString(1, uid);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		if (rs.next()) {
			member = new Member(rs.getInt("id"), rs.getString("uid"), rs.getString("email"), rs.getString("nickname"),
					rs.getString("pwd"), rs.getString("gender"), rs.getDate("regdate"));
		}

		rs.close();
		st.close();
		con.close();

		return member;
	}

	public int getMfcProductViewId(String mfcProduct) throws ClassNotFoundException, SQLException {
//		MfcProductView mpv=null;
		int id = 0;

		String sql = "SELECT id FROM MfcProductView WHERE `mfc-product`=?";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
//		Statement st = con.createStatement();

		st.setString(1, mfcProduct);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		if (rs.next()) {
			id = rs.getInt("id");
		}

		rs.close();
		st.close();
		con.close();

		return id;

	}

	// 부모id를 참조하는 자식 정보들
	public List<DiscussionCmt> getCmtByParent(int id) throws ClassNotFoundException, SQLException {
		List<DiscussionCmt> list = new ArrayList<DiscussionCmt>();

		String sql = "SELECT * FROM DiscussionCmt WHERE bossId=?";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			DiscussionCmt view = new DiscussionCmt(rs.getInt("id"), rs.getString("content"), rs.getString("writerName"),
					rs.getDate("regdate"), rs.getInt("likes"), rs.getInt("discussionId"), rs.getInt("bossId"));

			list.add(view);
		}

		rs.close();
		st.close();
		con.close();

		return list;

	}

	// 자세한페이지 댓글 목록
	public List<ReviewCmt> getReviewCmt(int id) throws SQLException, ClassNotFoundException {
		List<ReviewCmt> list = new ArrayList<ReviewCmt>();

		String sql = "SELECT * FROM ReviewCmt WHERE reviewId=? and bossId IS NULL";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			ReviewCmt view = new ReviewCmt(rs.getInt("id"), rs.getString("content"), rs.getString("writerName"),
					rs.getDate("regdate"), rs.getInt("likes"), rs.getInt("reviewId"), rs.getInt("bossId"));

			list.add(view);
		}

		rs.close();
		st.close();
		con.close();

		for (int i = 0; i < list.size(); i++) {
			ReviewCmt cmt = list.get(i);
			cmt.setChildren(getCmtByParent(cmt.getId()));
			;
		}

		return list;

	}

	public List<Topic> getTopicList() throws ClassNotFoundException, SQLException {
		List<Topic> list = new ArrayList<Topic>();

		String sql = "SELECT * FROM Topic";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		ResultSet rs = st.executeQuery();

		
		// 쿼리 실행 된 결과값 가져오기
		while (rs.next()) {
			Topic topic = new Topic(rs.getInt("id"),rs.getString("title"));

			list.add(topic);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public int getTopicId(String topic) throws ClassNotFoundException, SQLException {
		int id = 0;

		String sql = "SELECT id FROM Topic WHERE title=?";

		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);
//		Statement st = con.createStatement();

		st.setString(1, topic);

		ResultSet rs = st.executeQuery();

		// 쿼리 실행 된 결과값 가져오기
		if (rs.next()) {
			id = rs.getInt("id");
		}

		rs.close();
		st.close();
		con.close();

		return id;
	}
	
	// 자세한 페이지 조회
		public DiscussionListView getDiscussionDetailView(int id) throws ClassNotFoundException, SQLException {
			
			DiscussionListView rdv = null;

			String sql = "SELECT * FROM DiscussionListView WHERE id=?";
			
			String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				id = rs.getInt("id");
				String title = rs.getString("title");
				Date regdate = rs.getDate("regdate");
				String nickname = rs.getString("nickname");
				int hit = rs.getInt("hit");
				int likes = rs.getInt("likes");
				String content = rs.getString("content");
				int cmtCount = rs.getInt("cmtCount");
				String topic=rs.getString("topic");

				rdv = new DiscussionListView(id, title, topic, regdate, nickname, hit, likes, content,
						cmtCount);

			}
			

			rs.close();
			st.close();
			con.close();

			return rdv;
		}
		
		// 자세한페이지 댓글 목록
		public List<DiscussionCmt> getDiscussionCmt(int id) throws SQLException, ClassNotFoundException {
			List<DiscussionCmt> list = new ArrayList<DiscussionCmt>();

			String sql = "SELECT * FROM DiscussionCmt WHERE discussionId=? and bossId IS NULL";

			String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			// 쿼리 실행 된 결과값 가져오기
			while (rs.next()) {
				DiscussionCmt view = new DiscussionCmt(rs.getInt("id"), rs.getString("content"), rs.getString("writerName"),
						rs.getDate("regdate"), rs.getInt("likes"), rs.getInt("discussionId"), rs.getInt("bossId"));

				list.add(view);
			}

			rs.close();
			st.close();
			con.close();

			for (int i = 0; i < list.size(); i++) {
				DiscussionCmt cmt = list.get(i);
				cmt.setChildren(getCmtByParent(cmt.getId()));
				;
			}

			return list;

		}

//	public List<ReviewCmt> getChildren(int id) throws ClassNotFoundException, SQLException {
//		List<ReviewCmt> list=null;
//		
//		String sql = "SELECT R.id,C.id children FROM ReviewCmt R JOIN ReviewCmt C ON R.Id=C.bossId WHERE R.reviewId=?";
//
//		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
//		PreparedStatement st = con.prepareStatement(sql);
//		st.setInt(1, id);
//
//		ResultSet rs = st.executeQuery();
//
//		// 쿼리 실행 된 결과값 가져오기
//		while (rs.next()) {
//			ReviewCmt view = new ReviewCmt(rs.getInt("id"), rs.getString("content"), rs.getString("writerName"),
//					rs.getDate("regdate"), rs.getInt("likes"), rs.getInt("reviewId"),rs.getInt("bossId"));
//			list.add(view);
//		}
//
//		rs.close();
//		st.close();
//		con.close();
//
//		return list;
//
//		
//		return null;
//	}

}
