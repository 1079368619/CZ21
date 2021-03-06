package com.yc.mvc.po;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class JsjOrder implements java.io.Serializable{
	
	private static final long serialVersionUID = 2028909196711864219L;

	private Integer id;
	
	private Integer uid;
	
	private String addrName;
	
	private String addrPhone;
	
	private String addrDesc;
	
	private Double money;
	
	private Timestamp createTime;

	private Integer state;
	
	private String remark;

	private List<JsjOrderDetail> details;
	
	public List<JsjOrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List<JsjOrderDetail> details) {
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAddrName() {
		return addrName;
	}

	public void setAddrName(String addrName) {
		this.addrName = addrName;
	}

	public String getAddrPhone() {
		return addrPhone;
	}

	public void setAddrPhone(String addrPhone) {
		this.addrPhone = addrPhone;
	}

	public String getAddrDesc() {
		return addrDesc;
	}

	public void setAddrDesc(String addrDesc) {
		this.addrDesc = addrDesc;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "JsjOrder [id=" + id + ", uid=" + uid + ", addrName=" + addrName + ", addrPhone=" + addrPhone
				+ ", addrDesc=" + addrDesc + ", money=" + money + ", createTime=" + createTime + ", state=" + state
				+ ", remark=" + remark + ", details=" + details + "]";
	}

	
	
}
