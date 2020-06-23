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

import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.review.Grade;

import com.ramyunmoa.web.entity.review.Review;
import com.ramyunmoa.web.entity.review.ReviewCmt;
import com.ramyunmoa.web.view.review.MfcProductView;
import com.ramyunmoa.web.view.review.ReviewDetailView;
import com.ramyunmoa.web.view.review.ReviewListView;

public class ReviewService {

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
	public ReviewDetailView getReviewDetailView(int id) throws ClassNotFoundException, SQLException {
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
	}

	// 리뷰게시판 글 등록
	public int insertReview(Review review) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "INSERT INTO Review(title,content,productId,writerId,gradeId) VALUES(?,?,?,?,?)";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, review.getTitle());
		st.setString(2, review.getContent());
		st.setInt(3, review.getProductId());
		st.setInt(4, review.getWriterId());
		st.setInt(5, review.getGradeId());

		result = st.executeUpdate();

//		rs.close();
		st.close();
		con.close();

		return result;
	}

	// 자세한 페이지 수정
	public int updateReview(Review review) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE Review SET title=?,content=?,productId=?,gradeId=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는
//	  드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, review.getTitle());
		st.setString(2, review.getContent());
		st.setInt(3, review.getProductId());
		st.setInt(4, review.getGradeId());
		st.setInt(5, review.getId());

		result = st.executeUpdate();

		// rs.close(); st.close(); con.close();

		return result;
	}

	
	  // 자세한페이지 삭제 
	public int deleteReview(int id) throws ClassNotFoundException, SQLException {
	  
	  int result = 0;
	  
	  String sql = "DELETE FROM Review WHERE id=?"; 
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
	public List<ReviewListView> getReviewListView(String field, String query, int page)
			throws ClassNotFoundException, SQLException {
		List<ReviewListView> list = new ArrayList<ReviewListView>();

		String sql = "SELECT * FROM ReviewListView " + " WHERE " + field
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
			ReviewListView review = new ReviewListView(rs.getInt("id"), rs.getInt("writerId"),
					rs.getString("mfc-product"), rs.getInt("gradeId"), rs.getString("title"), rs.getString("nickname"),
					rs.getDate("regdate"), rs.getString("logo"), rs.getString("img"), rs.getInt("cmtCount"));
			list.add(review);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	// 리뷰 게시판 글 갯수
	public int getReviewCount(String field, String query) throws ClassNotFoundException, SQLException {

		int count = 0;

		String sql = "SELECT COUNT(ID) COUNT FROM ReviewListView " + " WHERE " + field
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
	public ReviewCmt insertCmt(ReviewCmt cmt) throws SQLException, ClassNotFoundException {

		int result = 0;
		ReviewCmt cmt2 = null;
		String sql = "";
		boolean flag = false;

		if (cmt.getBossId() == -1) { // 대댓글이 아니라면
			sql = "INSERT INTO ReviewCmt(writerName, content,reviewId) VALUES(?,?,?)";
		} else { // 대댓글이면
			sql = "INSERT INTO ReviewCmt(writerName, content,reviewId,bossId) VALUES(?,?,?,?)";
			flag = true;
		}

		String sql2 = "SELECT * FROM ReviewCmt WHERE writerName=? ORDER BY REGDATE DESC LIMIT 1"; // 최근 데이터 하나만 추출

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
			st.setInt(3, cmt.getReviewId());

			System.out.println("rs2222222222222:");
			result = st.executeUpdate();

			st2 = con.prepareStatement(sql2);
			st2.setString(1, cmt.getWriterName());

			System.out.println("rs2222:");

			rs2 = st2.executeQuery();

			System.out.println("rs2:");
			System.out.println(rs2);
			if (rs2.next()) {
				cmt2 = new ReviewCmt();
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
	public List<ReviewCmt> getCmtByParent(int id) throws ClassNotFoundException, SQLException {
		List<ReviewCmt> list = new ArrayList<ReviewCmt>();

		String sql = "SELECT * FROM ReviewCmt WHERE bossId=?";

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

	public int addLike(int reviewId) throws ClassNotFoundException, SQLException {
		int result = 0;

		String sql = "UPDATE SET Review likes=likes+1 WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/rmteam?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "rmteam", "rm0322");
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, reviewId);

		result = st.executeUpdate();

//		rs.close();
		st.close();
		con.close();

		return result;
		
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
