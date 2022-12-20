package com.demo.domain;

public enum RoomType {
	Economy("經濟型"), Business("商務型"), Luxury("豪華型");

	private String chineseName;

	RoomType(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

}
