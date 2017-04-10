package com.mrj.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.mrj.common.util.Page;
import com.mrj.vo.RoleVo;

public interface RoleService {

	public List<RoleVo> finRoleByUserId(String userId);
	
	public List<RoleVo> finRole(RoleVo role, RowBounds rowBounds);

	public Page<RoleVo> finRolePage(RoleVo role, RowBounds rowBounds);

	public RoleVo findRoleByPrimaryKey(String roleId);

	public void insertRole(RoleVo role);

	public void updateRole(RoleVo role);

	public void deleteRoleByPrimaryKey(String roleId);

}
