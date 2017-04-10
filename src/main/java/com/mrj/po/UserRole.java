package com.mrj.po;

import com.mrj.po.base.BasePo;

public class UserRole extends BasePo{
    private String userid;

    private String roleid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

	@Override
	public String getMapperNameSpace() {
		return null;
	}
}