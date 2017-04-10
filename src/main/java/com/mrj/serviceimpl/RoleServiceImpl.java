package com.mrj.serviceimpl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrj.common.util.Page;
import com.mrj.dao.RoleDao;
import com.mrj.dao.base.BaseDao;
import com.mrj.po.RolePermission;
import com.mrj.service.RoleService;
import com.mrj.vo.PermissionVo;
import com.mrj.vo.RoleVo;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public List<RoleVo> finRoleByUserId(String userId) {
		return roleDao.selectByUserId(userId);
	}

	@Override
	public RoleVo findRoleByPrimaryKey(String roleId) {
		return baseDao.selectByPrimaryKey(RoleVo.class, roleId);
	}

	@Override
	public List<RoleVo> finRole(RoleVo role, RowBounds rowBounds) {
		return baseDao.selectByObject(role, rowBounds);
	}
	
	@Override
	public Page<RoleVo> finRolePage(RoleVo role, RowBounds rowBounds) {
		return baseDao.selectPageByObject(role, rowBounds);
	}

	@Override
	public void insertRole(RoleVo role) {
		baseDao.insert(role);
		insertPermissionMapping(role);
	}

	@Override
	public void updateRole(RoleVo role) {
		RolePermission rp = new RolePermission();
		rp.setRoleid(role.getRoleid());
		baseDao.deleteByObject(rp);
		baseDao.updateByPrimaryKey(role);
		insertPermissionMapping(role);
	}

	@Override
	public void deleteRoleByPrimaryKey(String roleId) {
		RolePermission rp = new RolePermission();
		rp.setRoleid(roleId);
		baseDao.deleteByObject(rp);
		baseDao.deleteByPrimaryKey(RoleVo.class, roleId);
	}

	private void insertPermissionMapping(RoleVo roleVo) {
		if(roleVo.getPermissions() != null && roleVo.getPermissions().size() > 0){
			for (PermissionVo permissionVo : roleVo.getPermissions()) {
				RolePermission rp = new RolePermission();
				rp.setRoleid(roleVo.getRoleid());
				rp.setPermissionid(permissionVo.getPermissionid());
				baseDao.insert(rp);
			}
		}
	}

}
