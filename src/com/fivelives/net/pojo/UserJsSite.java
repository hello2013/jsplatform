package com.fivelives.net.pojo;

//import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserJsSite {
	
//	public static ConcurrentHashMap<String, UserJsSite> UserJsonpMap = new ConcurrentHashMap<String, UserJsSite>();
	private String pub;
	private String slot;
	private String src;
	private Double ratio;
	private Integer maxcount;
	private Integer ua_type;
	
	
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
	public Integer getUa_type() {
		return ua_type;
	}
	public void setUa_type(Integer ua_type) {
		this.ua_type = ua_type;
	}
	static Lock lock = new ReentrantLock();
//	public static UserJsSite getUserJsonp(String pub, String slot, String src) {
//		UserJsSite uj =UserJsonpMap.get(slot);
//		if(null == uj){
//			lock.lock();
//			uj =UserJsonpMap.get(slot);
//			if(uj!=null){
//				lock.unlock();
//				return uj;
//			}
//			try{
//				uj = new UserJsSite();
//				uj.setPub(pub);
//				uj.setSlot(slot);
//				uj.setSrc(src);
//				UserJsonpMap.put(slot, uj);
//			}finally{
//				lock.unlock();
//			}
//		}
//		return uj;
//	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	
}
