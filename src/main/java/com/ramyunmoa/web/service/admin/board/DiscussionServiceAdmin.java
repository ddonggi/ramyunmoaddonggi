package com.ramyunmoa.web.service.admin.board;

import java.sql.SQLException;
import java.util.List;

import com.ramyunmoa.web.entity.admin.board.BoardAdmin;

public class DiscussionServiceAdmin {

	public List<BoardAdmin> getDiscussionNoticeList(String searchName, int page)
			throws SQLException, ClassNotFoundException {

		// TODO Auto-generated method stub
		return null;
	}

	public int getDiscussionNoticeCount(String searchName) throws ClassNotFoundException, SQLException {

		return 0;
	}

	public List<BoardAdmin> getDiscussionReportList(String searchName, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDiscussionReportCount(String searchName) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<BoardAdmin> getDiscussionBoardList(String searchName, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDiscussionBoardCount(String searchName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
