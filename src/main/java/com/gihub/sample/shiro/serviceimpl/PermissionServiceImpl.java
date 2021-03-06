package com.gihub.sample.shiro.serviceimpl;

import java.util.List;

import com.gihub.sample.shiro.dao.base.BaseDao;
import com.gihub.sample.shiro.po.RolePermission;
import com.gihub.sample.shiro.service.PermissionService;
import com.gihub.sample.shiro.vo.PermissionVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gihub.sample.shiro.common.util.Page;
import com.gihub.sample.shiro.dao.PermissionDao;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private PermissionDao permissionDao;

	@Override
	public PermissionVo finPermissionByPrimaryKey(String permissionId) {
		return baseDao.selectByPrimaryKey(PermissionVo.class, permissionId);
	}

	@Override
	public List<PermissionVo> finPermission(PermissionVo permission, RowBounds rowBounds) {
		return baseDao.selectByObject(permission, rowBounds);
	}

	@Override
	public Page<PermissionVo> finPermissionPage(PermissionVo permission, RowBounds rowBounds) {
		return baseDao.selectPageByObject(permission, rowBounds);
	}

	@Override
	public void insertPermission(PermissionVo permission) {
		baseDao.insert(permission);
	}

	@Override
	public void updatePermission(PermissionVo permission) {
		baseDao.updateByPrimaryKey(permission);
	}

	@Override
	public void deletePermissionByPrimaryKey(String permissionId) {
		RolePermission rp = new RolePermission();
		rp.setPermissionid(permissionId);
		baseDao.deleteByObject(rp);
		baseDao.deleteByPrimaryKey(PermissionVo.class, permissionId);
	}

	@Override
	public List<PermissionVo> getUserPermissionByUserId(String userID) {
		return permissionDao.selectByUserId(userID);
	}

}
