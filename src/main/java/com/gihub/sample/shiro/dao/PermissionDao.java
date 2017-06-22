package com.gihub.sample.shiro.dao;

import java.util.List;

import com.gihub.sample.shiro.vo.PermissionVo;

public interface PermissionDao {

	public List<PermissionVo> selectByUserId(String userId);

	public List<PermissionVo> selectByRoleId(String roleId);
}
