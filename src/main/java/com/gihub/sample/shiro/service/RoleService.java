package com.gihub.sample.shiro.service;

import java.util.List;

import com.gihub.sample.shiro.vo.RoleVo;
import org.apache.ibatis.session.RowBounds;

import com.gihub.sample.shiro.common.util.Page;

public interface RoleService {

	public List<RoleVo> finRoleByUserId(String userId);
	
	public List<RoleVo> finRole(RoleVo role, RowBounds rowBounds);

	public Page<RoleVo> finRolePage(RoleVo role, RowBounds rowBounds);

	public RoleVo findRoleByPrimaryKey(String roleId);

	public void insertRole(RoleVo role);

	public void updateRole(RoleVo role);

	public void deleteRoleByPrimaryKey(String roleId);

}
