package com.gihub.sample.shiro.test.shiro;

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

import com.gihub.sample.shiro.test.BaseTest;

/**
 * ��spring����
 * @author ��Administrator
 * @modified:
 * ��Administrator(2017��2��25�� ����3:47:41): <br>
 */
public class TestShiro extends BaseTest{
	
	private static Logger logger = LoggerFactory.getLogger(TestShiro.class);
	
	@BeforeClass
	public static void init(){
	}
	
	@Test  
	public void testlogin() {  
	    //3���õ�Subject�������û���/���������֤Token�����û����/ƾ֤��  
	    Subject subject = SecurityUtils.getSubject();  
	    UsernamePasswordToken token = new UsernamePasswordToken("xiaoming", "123");
	    try {  
	        //4����¼���������֤  
	        subject.login(token); 
//	        subject.checkRole("r1");
//	        subject.checkPermission("p1");
	    } catch (AuthenticationException e) {  
	        logger.debug(subject.getPrincipal()+" login failure", e);
	    }  
	  
	    Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼  
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
