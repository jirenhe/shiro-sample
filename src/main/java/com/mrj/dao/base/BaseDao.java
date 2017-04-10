package com.mrj.dao.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.mrj.common.util.Page;
import com.mrj.po.base.BasePo;

public interface BaseDao {

	public int insert(BasePo object);

	public int deleteByPrimaryKey(Class<? extends BasePo> clazz, Object primaryKey);

	public int deleteByObject(BasePo object);

	public int updateByPrimaryKey(BasePo object);

	public int selectCount(BasePo object);

	public <T> T selectByPrimaryKey(Class<? extends BasePo> clazz, Object primaryKey);

	public <T> List<T> selectByObject(BasePo object);

	public <T> List<T> selectByObject(BasePo object, RowBounds rowBounds);

	public <T> Page<T> selectPageByObject(BasePo object, RowBounds rowBounds);

}
