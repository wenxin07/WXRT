package com.demo.domain.location;

public enum City {
	KeelungCity("基隆市"), TaipeiCity("台北市"), NewTaipeiCity("新北市"), TaoyuanCity("桃園市"), HsinchuCounty("新竹縣"), HsinchuCity("新竹市"), MiaoliCounty("苗栗縣"), TaichungCity("台中市"),
	ChanghuaCounty("彰化縣"), NantouCounty("南投縣"), YunlinCounty("雲林縣"), ChiayiCounty("嘉義縣"), ChiayiCity("嘉義市"), TainanCity("台南市"), KaohsiungCity("高雄市"), PingtungCounty("屏東縣"),
	TaitungCounty("台東縣"), HualienCounty("花蓮縣"), YilanCounty("宜蘭縣"), PenghuCounty("澎湖縣"), KinmenCounty("金門縣"), LienchiangCounty("連江縣");

	private String chineseName;

	City (String chineseName) {
        this.chineseName = chineseName;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
}
