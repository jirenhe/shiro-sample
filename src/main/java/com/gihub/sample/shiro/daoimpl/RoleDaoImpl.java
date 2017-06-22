package com.gihub.sample.shiro.daoimpl;

import java.util.List;

import com.gihub.sample.shiro.common.util.DaoUtil;
import com.gihub.sample.shiro.daoimpl.base.BaseDaoImpl;
import com.gihub.sample.shiro.po.Role;
import com.gihub.sample.shiro.vo.RoleVo;
import org.springframework.stereotype.Repository;

import com.gihub.sample.shiro.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

	@Override
	public List<RoleVo> selectByUserId(String userId) {
		String statement = DaoUtil.getMapperNameSpace(Role.class)+".selectByUserId";
		return getSqlSession().selectList(statement, userId);
	}
}
