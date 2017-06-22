package com.gihub.sample.shiro.service;

import java.util.List;

import com.gihub.sample.shiro.vo.PermissionVo;
import org.apache.ibatis.session.RowBounds;

import com.gihub.sample.shiro.common.util.Page;

public interface PermissionService {

	public PermissionVo finPermissionByPrimaryKey(String permissionId);

	public List<PermissionVo> finPermission(PermissionVo permission, RowBounds rowBounds);
	
	public List<PermissionVo> getUserPermissionByUserId(String userID);

	public Page<PermissionVo> finPermissionPage(PermissionVo permission, RowBounds rowBounds);

	public void insertPermission(PermissionVo permission);

	public void updatePermission(PermissionVo permission);

	public void deletePermissionByPrimaryKey(String permissionId);

}
