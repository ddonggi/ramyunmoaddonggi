package com.ramyunmoa.web.view.review;

import java.util.Date;

public class DiscussionDetailView {
	private int id;
	private String title;
	private Date regdate;
	private String nickname;
	private int hit;
	private int likes;
	private String content;
	private int cmtCount;
	private int topicId;
	
	
	public DiscussionDetailView() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DiscussionDetailView(int id, String title, int topicId, Date regdate, String nickname, int hit,
			int likes, String content, int cmtCount) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.nickname= nickname;
		this.hit = hit;
		this.likes = likes;
		this.content = content;
		this.cmtCount=cmtCount;
		this.topicId=topicId;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public int getHit() {
		return hit;
	}



	public void setHit(int hit) {
		this.hit = hit;
	}



	public int getLikes() {
		return likes;
	}



	public void setLikes(int likes) {
		this.likes = likes;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getCmtCount() {
		return cmtCount;
	}



	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}



	public int getTopicId() {
		return topicId;
	}



	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}



	@Override
	public String toString() {
		return "DiscussionDetailView [id=" + id + ", title=" + title + ", regdate=" + regdate + ", nickname=" + nickname
				+ ", hit=" + hit + ", likes=" + likes + ", content=" + content + ", cmtCount=" + cmtCount + ", topicId="
				+ topicId + "]";
	}
	
}
	