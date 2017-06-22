package com.gihub.sample.shiro.serviceimpl;

import java.util.List;

import com.gihub.sample.shiro.common.util.Page;
import com.gihub.sample.shiro.dao.base.BaseDao;
import com.gihub.sample.shiro.po.UserRole;
import com.gihub.sample.shiro.service.UserService;
import com.gihub.sample.shiro.vo.UserVo;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gihub.sample.shiro.po.Role;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao baseDao;

	@Override
	public void insertUser(UserVo user) {
		baseDao.insert(user);
		insertRoleMapping(user);
	}

	@Override
	public void updateUser(UserVo user) {
		UserRole userRole = new UserRole();
		userRole.setUserid(user.getUserid());
		baseDao.deleteByObject(userRole);
		baseDao.updateByPrimaryKey(user);
		insertRoleMapping(user);
	}

	@Override
	public void deleteUserByPrimaryKey(String userId) {
		UserRole userRole = new UserRole();
		userRole.setUserid(userId);
		baseDao.deleteByObject(userRole);
		baseDao.deleteByPrimaryKey(UserVo.class, userId);
	}


	@Override
	public UserVo finUserByPrimaryKey(String userId) {
		return baseDao.selectByPrimaryKey(UserVo.class, userId);
	}

	@Override
	public List<UserVo> finUser(UserVo user, RowBounds rowBounds) {
		return baseDao.selectByObject(user,rowBounds);
	}
	
	@Override
	public Page<UserVo> finUserPage(UserVo user, RowBounds rowBounds) {
		return baseDao.selectPageByObject(user, rowBounds);
	}
	
	private void insertRoleMapping(UserVo user) {
		if(user.getRoles() != null && user.getRoles().size() > 0){
			for (Role role : user.getRoles()) {
				UserRole userRole = new UserRole();
				userRole.setRoleid(role.getRoleid());
				userRole.setUserid(user.getUserid());
				baseDao.insert(userRole);
			}
		}
	}

}
