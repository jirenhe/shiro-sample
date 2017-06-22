package com.gihub.sample.shiro.service;

import java.util.List;

import com.gihub.sample.shiro.vo.UserVo;
import org.apache.ibatis.session.RowBounds;

import com.gihub.sample.shiro.common.util.Page;

public interface UserService {

	public UserVo finUserByPrimaryKey(String userId);

	public List<UserVo> finUser(UserVo user, RowBounds rowBounds);

	public Page<UserVo> finUserPage(UserVo user, RowBounds rowBounds);

	public void insertUser(UserVo user);

	public void updateUser(UserVo user);

	public void deleteUserByPrimaryKey(String userId);
}
