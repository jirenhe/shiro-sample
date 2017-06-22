package com.gihub.sample.shiro.po;

import com.gihub.sample.shiro.po.base.BasePo;

public class Role extends BasePo {
    private String roleid;

    private String rolename;

    private String remark;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", remark=" + remark + "]";
	}
    
	@Override
	public String getMapperNameSpace() {
		return "com.mrj.dao.RoleMapper";
	}
}