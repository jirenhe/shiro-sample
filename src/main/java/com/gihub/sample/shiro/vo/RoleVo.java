package com.gihub.sample.shiro.vo;

import java.util.List;

import com.gihub.sample.shiro.po.Role;

public class RoleVo extends Role{

	private List<PermissionVo> Permissions;

	public List<PermissionVo> getPermissions() {
		return Permissions;
	}

	public void setPermissions(List<PermissionVo> permissions) {
		Permissions = permissions;
	}

}
