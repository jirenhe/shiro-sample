package com.mrj.daoimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrj.common.util.DaoUtil;
import com.mrj.dao.PermissionDao;
import com.mrj.vo.PermissionVo;

@Repository("permissionDao")
public class PermissionDaoImpl implements PermissionDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<PermissionVo> selectByUserId(String userId) {
		String statement = DaoUtil.getMapperNameSpace(PermissionVo.class)+".selectByUserId";
		return sqlSession.selectList(statement, userId);
	}

	@Override
	public List<PermissionVo> selectByRoleId(String roleId) {
		String statement = DaoUtil.getMapperNameSpace(PermissionVo.class)+".selectByRoleId";
		return sqlSession.selectList(statement, roleId);
	}

}
