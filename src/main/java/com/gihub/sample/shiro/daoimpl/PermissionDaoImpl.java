package com.gihub.sample.shiro.daoimpl;

import java.util.List;

import com.gihub.sample.shiro.common.util.DaoUtil;
import com.gihub.sample.shiro.dao.PermissionDao;
import com.gihub.sample.shiro.vo.PermissionVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
