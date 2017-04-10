package com.mrj.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.mrj.common.util.Page;
import com.mrj.vo.UserVo;

public interface UserService {

	public UserVo finUserByPrimaryKey(String userId);

	public List<UserVo> finUser(UserVo user, RowBounds rowBounds);

	public Page<UserVo> finUserPage(UserVo user, RowBounds rowBounds);

	public void insertUser(UserVo user);

	public void updateUser(UserVo user);

	public void deleteUserByPrimaryKey(String userId);
}
