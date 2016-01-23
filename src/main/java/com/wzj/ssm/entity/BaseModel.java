package com.wzj.ssm.entity;

import java.io.Serializable;
import java.util.Date;

import com.wzj.ssm.util.ContextUtil;
import com.wzj.ssm.util.DateFunc;



public class BaseModel implements Serializable {
	
	protected Integer createby;
	
	protected Date createtime;
    
	protected Integer updateby;
	
	protected Date updatetime;

	public Integer getCreateby() {
		return createby;
	}
	public void setCreateby(Integer createby) {
		this.createby = createby;
		if ((createby == null) || (createby.intValue() == 0))
			this.createby = ContextUtil.getCurrentTeacherId();
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
		if (createtime == null)
			this.createtime = DateFunc.getNow();
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
		if (updatetime == null)
			this.updatetime = DateFunc.getNow();
	}
	public Integer getUpdateby() {
		return updateby;
	}
	public void setUpdateby(Integer updateby) {
		this.updateby = updateby;
		if ((updateby == null) || (updateby.intValue() == 0))
			this.updateby = ContextUtil.getCurrentTeacherId();
	}
	
}
