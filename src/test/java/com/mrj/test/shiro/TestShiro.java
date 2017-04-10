package com.mrj.test.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mrj.test.BaseTest;

/**
 * 与spring集成
 * @author ★Administrator
 * @modified:
 * ☆Administrator(2017年2月25日 下午3:47:41): <br>
 */
public class TestShiro extends BaseTest{
	
	private static Logger logger = LoggerFactory.getLogger(TestShiro.class);
	
	@BeforeClass
	public static void init(){
	}
	
	@Test  
	public void testlogin() {  
	    //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("xiaoming", "123");
	    try {  
	        //4、登录，即身份验证  
	        subject.login(token); 
//	        subject.checkRole("r1");
//	        subject.checkPermission("p1");
	    } catch (AuthenticationException e) {  
	        logger.debug(subject.getPrincipal()+" login failure", e);
	    }  
	  
	    Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录  
	    logger.debug(subject.getPrincipal()+" login sucess");
	} 
	
	@Test
	public void testLoginPrincipal(){
		testlogin();
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		for (Object obj : principalCollection.asList()) {
			logger.debug("--------"+obj.toString());
		}
		subject.checkPermission("p1:delete");
		subject.checkPermission("user:delete");
//		subject.checkPermission("p2");
		subject.logout();
	}
}
