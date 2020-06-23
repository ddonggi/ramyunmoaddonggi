package com.ramyunmoa.web.view.review;

import java.util.Date;

public class DiscussionListView {
	private int id;
	private int writerId;
	private String title;
	private String nickname;
	private Date regdate;
	private int cmtCount;
	private String content;
	private String topic;
	private int topicId;
	private int likes;
	private int hit;
	
	public DiscussionListView() {
		// TODO Auto-generated constructor stub
	}

	

	public DiscussionListView(int id, int writerId, String title, String nickname, Date regdate, int cmtCount,
			String content, String topic, int topicId, int likes, int hit) {
		this.id=id;
		this.writerId=writerId;
		this.title=title;
		this.nickname=nickname;
		this.regdate=regdate;
		this.cmtCount=cmtCount;
		this.content=content;
		this.topic=topic;
		this.topicId=topicId;
		this.likes=likes;
		this.hit=hit;
	}



	public DiscussionListView(int id, String title, String topic, Date regdate, String nickname, int hit,
			int likes, String content, int cmtCount) {
		this.id=id;
		this.title=title;
		this.nickname=nickname;
		this.regdate=regdate;
		this.cmtCount=cmtCount;
		this.content=content;
		this.topic=topic;
		this.likes=likes;
		this.hit=hit;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWriterId() {
		return writerId;
	}
	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCmtCount() {
		return cmtCount;
	}
	public void setCmtCount(int cmtCount) {
		this.cmtCount = cmtCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}



	@Override
	public String toString() {
		return "DiscussionListView [id=" + id + ", writerId=" + writerId + ", title=" + title + ", nickname=" + nickname
				+ ", regdate=" + regdate + ", cmtCount=" + cmtCount + ", content=" + content + ", topic=" + topic
				+ ", topicId=" + topicId + ", likes=" + likes + ", hit=" + hit + "]";
	}

	
	
	
}