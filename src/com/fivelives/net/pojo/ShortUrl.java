package com.fivelives.net.pojo;

public class ShortUrl {
	private String name;
	private String url;
	private Double ratio;
	private Integer maxcount;
	private Integer ua_type;
	
	
	public Integer getUa_type() {
		return ua_type;
	}
	public void setUa_type(Integer ua_type) {
		this.ua_type = ua_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Double getRatio() {
		return ratio;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	public Integer getMaxcount() {
		return maxcount;
	}
	public void setMaxcount(Integer maxcount) {
		this.maxcount = maxcount;
	}
}
