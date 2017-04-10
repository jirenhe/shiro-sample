package com.mrj.dao;

import java.util.List;

import com.mrj.vo.RoleVo;

public interface RoleDao{

	public List<RoleVo> selectByUserId(String userId);
}
