package com.gihub.sample.shiro.po;

import com.gihub.sample.shiro.po.base.BasePo;

public class RolePermission extends BasePo{
    private String roleid;

    private String permissionid;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid == null ? null : permissionid.trim();
    }

	@Override
	public String getMapperNameSpace() {
		return null;
	}
}