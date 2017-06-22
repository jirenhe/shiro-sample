package com.gihub.sample.shiro.test.simple;

import java.util.Arrays;
import java.util.List;

import com.gihub.sample.shiro.service.UserService;
import com.gihub.sample.shiro.test.BaseTest;
import com.gihub.sample.shiro.vo.PermissionVo;
import com.gihub.sample.shiro.vo.RoleVo;
import com.gihub.sample.shiro.vo.UserVo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gihub.sample.shiro.common.util.Page;

public class TestUser extends BaseTest {

	@Autowired
	private UserService userService;

	
	@Test
	public void testUser() {
		UserVo user = userService.finUserByPrimaryKey("1");
		System.out.println(user);
		for (RoleVo roleVo : user.getRoles()) {
			System.out.println("---"+roleVo);
			for (PermissionVo permissionVo : roleVo.getPermissions()) {
				System.out.println("-------"+permissionVo);
			}
		}
		for (PermissionVo permissionVo : user.getPermissions()) {
			System.out.println("---"+permissionVo);
		}
	}

	@Test
	public void testInsert() {
		RoleVo r1 = new RoleVo();
		RoleVo r2 = new RoleVo();
		r1.setRoleid("r1");
		r2.setRoleid("r2");
		UserVo user = new UserVo();
		user.setUserid("4");
		user.setUsername("lisi");
		user.setPassword("123");
		user.setRoles(Arrays.asList(r1, r2));
		userService.insertUser(user);
	}

	@Test
	public void testFindUser() {
		UserVo user = new UserVo();
		Page<UserVo> page = userService.finUserPage(user, new RowBounds());
		List<UserVo> list = page.getRecords();
		System.out.println("totalcount:"+page.getTotalCount());
		System.out.println("totalPage:"+page.getTotalPage());
		for (UserVo userVo : list) {
			System.out.println(userVo);
			for (RoleVo ro : userVo.getRoles()) {
				System.out.println("---------" + ro);
			}
			System.out.println("-------------------------------");
			for (PermissionVo per : userVo.getPermissions()) {
				System.out.println("---------" + per);
			}
		}
	}

	@Test
	public void testUpdate() {
		String userId = "3";
		UserVo user = userService.finUserByPrimaryKey(userId);
		System.out.println(user);
		user.setUsername("wangwu");
		user.setPassword("567");
		RoleVo ro = new RoleVo();
		ro.setRoleid("r2");
		user.setRoles(Arrays.asList(ro));
		userService.updateUser(user);
		UserVo user2 = userService.finUserByPrimaryKey("3");
		System.out.println(user2);
		for (RoleVo ro1 : user2.getRoles()) {
			System.out.println(ro1);
		}
	}

	@Test
	public void testDelete() {
		String userId = "3";
		UserVo user = userService.finUserByPrimaryKey(userId);
		System.out.println(user);
		for (RoleVo ro1 : user.getRoles()) {
			System.out.println(ro1);
		}
		userService.deleteUserByPrimaryKey(userId);
	}
}
