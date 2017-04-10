package com.mrj.daoimpl.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mrj.common.util.Page;
import com.mrj.dao.base.BaseDao;
import com.mrj.po.base.BasePo;

@Repository("baseDao")
public abstract class BaseDaoImpl implements BaseDao {

	private final String separator = ".";

	@Autowired
	private SqlSession sqlSession;

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insert(BasePo po) {
		String statement = insertStatement(po);
		return sqlSession.insert(statement, po);
	}

	@Override
	public int deleteByPrimaryKey(Class<? extends BasePo> clazz, Object primaryKey) {
		BasePo po = null;
		try {
			po = clazz.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("class:"+clazz+" can not be instanced !");
		}
		String statement = deleteByPrimaryKeyStatement(po);
		po = null;
		return sqlSession.delete(statement, primaryKey);
	}

	@Override
	public int deleteByObject(BasePo po) {
		String statement = deleteByObjectStatement(po);
		return sqlSession.delete(statement, po);
	}

	@Override
	public int updateByPrimaryKey(BasePo po) {
		String statement = updateByPrimaryKeyStatement(po);
		return sqlSession.update(statement, po);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T>T selectByPrimaryKey(Class<? extends BasePo> clazz, Object primaryKey) {
		BasePo po = null;
		try {
			po = clazz.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("class:"+clazz+" can not be instanced !");
		}
		String statement = selectByPrimaryKeyStatement(po);
		po = sqlSession.selectOne(statement, primaryKey);
		return (T) po;
	}

	@Override
	public <T> List<T> selectByObject(BasePo po) {
		return this.selectByObject(po, null);
	}

	@Override
	public <T> List<T> selectByObject(BasePo po, RowBounds rowBounds) {
		String statement = selectByObjectStatement(po);
		if (null == rowBounds) {
			return sqlSession.selectList(statement, po);
		} else {
			return sqlSession.selectList(statement, po, rowBounds);
		}
	}

	@Override
	public <T> Page<T> selectPageByObject(BasePo po, RowBounds rowBounds) {
		Page<T> page = new Page<T>(rowBounds);
		List<T> list = this.selectByObject(po, rowBounds);
		int count = this.selectCount(po);
		page.setTotalCount(count);
		page.setRecords(list);
		return page;
	}

	@Override
	public int selectCount(BasePo po) {
		String statement = selectCountStatement(po);
		return sqlSession.selectOne(statement, po);
	}

	public String insertStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "insertSelective";
	}

	public String deleteByPrimaryKeyStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "deleteByPrimaryKey";
	}

	public String deleteByObjectStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "deleteByObject";
	}

	public String updateByPrimaryKeyStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "updateByPrimaryKeySelective";
	}

	public String selectByPrimaryKeyStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "selectByPrimaryKey";
	}

	public String selectByObjectStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "selectByObject";
	}

	public String selectCountStatement(BasePo po) {
		return po.getMapperNameSpace() + separator + "selectCount";
	}
}
