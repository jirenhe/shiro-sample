package com.mrj.test.simple;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mrj.service.PermissionService;
import com.mrj.test.BaseTest;
import com.mrj.vo.PermissionVo;

public class TestPermission extends BaseTest {

	@Autowired
	private PermissionService permissionService;

	@Test
	public void testFindByPrimaryKey(){
		System.out.println(permissionService.finPermissionByPrimaryKey("p1"));
	}
	
	@Test
	public void testFind() {
		// Page<PermissionVo> page = new Page<PermissionVo>();
		// permissionMapper.selectByPage();
		// permissionMapper.haha();
		PermissionVo per = new PermissionVo();
		per.setPermissionid("p1");
		List<PermissionVo> list = permissionService.finPermission(per, null);
		for (PermissionVo permissionVo : list) {
			System.out.println(permissionVo);
		}
	}

	@Test
	public void testUpdate() {
		PermissionVo per = permissionService.finPermissionByPrimaryKey("p1");
		per.setPermissionname("p1:query");
		permissionService.updatePermission(per);
	}

	@Test
	public void testInsert() {
		PermissionVo per = new PermissionVo();
		per.setPermissionid("p4");
		per.setPermissionname("p4:*");
		per.setRemark("p4");
		permissionService.insertPermission(per);
	}

	@Test
	@Transactional
	public void testDelete() {
		permissionService.deletePermissionByPrimaryKey("p2");
	}
}
