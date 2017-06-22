package com.gihub.sample.shiro.dao;

import java.util.List;

import com.gihub.sample.shiro.vo.RoleVo;

public interface RoleDao{

	public List<RoleVo> selectByUserId(String userId);
}
