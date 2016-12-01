package com.po;

public class KnowLedgeLecture {
	
	private Integer id;//视频Id

	private String title;//视频标题

	private String cover;//视频图片

	private String video;//视频

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "KnowLedgeLecture [id=" + id + ", title=" + title + ", cover=" + cover + ", video=" + video + "]";
	}
	
	
}
