package com.mrj.po;

import com.mrj.po.base.BasePo;

public class Permission extends BasePo{
	
    private String permissionid;

    private String permissionname;

    private String remark;

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "Permission [permissionid=" + permissionid + ", permissionname=" + permissionname + ", remark=" + remark
				+ "]";
	}
    
	@Override
	public String getMapperNameSpace() {
		return "com.mrj.dao.PermissionMapper";
	}
}