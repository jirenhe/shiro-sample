package com.mrj.dao;

import java.util.List;

import com.mrj.vo.PermissionVo;

public interface PermissionDao {

	public List<PermissionVo> selectByUserId(String userId);

	public List<PermissionVo> selectByRoleId(String roleId);
}
