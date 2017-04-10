package com.mrj.vo;

import java.util.List;

import com.mrj.po.User;

public class UserVo extends User {

	private List<RoleVo> roles;

	private List<PermissionVo> permissions;

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}

	public List<PermissionVo> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionVo> permissions) {
		this.permissions = permissions;
	}


}
