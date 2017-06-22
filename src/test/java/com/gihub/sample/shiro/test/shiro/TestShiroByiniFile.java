package com.gihub.sample.shiro.test.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * shiro.ini�ļ�����shiro
 * @author ��Administrator
 * @modified:
 * ��Administrator(2017��2��25�� ����3:47:41): <br>
 */
public class TestShiroByiniFile {
	
	private static Logger logger;
	
	@BeforeClass
	public static void init(){
		logger = Logger.getLogger(TestShiro.class);
		Factory<org.apache.shiro.mgt.SecurityManager> factory = null;
		try {
			factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    //2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
	    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();  
	    SecurityUtils.setSecurityManager(securityManager);   
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
	        e.printStackTrace();
	        logger.debug(subject.getPrincipal()+" login failure");
	    }  
	  
//	    Assert.assertEquals(true, subject.isAuthenticated()); //�����û��Ѿ���¼  
//	    logger.debug(subject.getPrincipal()+" login sucess");
	} 
	
	@Test
	public void testLoginPrincipal(){
		testlogin();
		Subject subject = SecurityUtils.getSubject();
		PrincipalCollection principalCollection = subject.getPrincipals();
		for (Object obj : principalCollection.asList()) {
			logger.debug("--------"+obj.toString());
		}
		subject.checkPermission("user:delete");
		subject.checkPermission("p1:delete");
		subject.logout();
	}
}
