package com.mrj.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mrj.common.util.DaoUtil;
import com.mrj.dao.RoleDao;
import com.mrj.daoimpl.base.BaseDaoImpl;
import com.mrj.po.Role;
import com.mrj.vo.RoleVo;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl implements RoleDao {

	@Override
	public List<RoleVo> selectByUserId(String userId) {
		String statement = DaoUtil.getMapperNameSpace(Role.class)+".selectByUserId";
		return getSqlSession().selectList(statement, userId);
	}
}
