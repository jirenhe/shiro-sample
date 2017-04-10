package com.mrj.common.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm2 extends AuthorizingRealm {
	
	private Logger logger = Logger.getLogger(MyRealm2.class);


	@Override
	public String getName() {
		return "MyRealm2";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		logger.debug(token.getPrincipal());
		logger.debug(token.getCredentials());
		return token instanceof UsernamePasswordToken;
	}


	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRole("r2");
		info.addRole("r3");
		info.addStringPermission("user:*");
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
//		return new SimpleAuthenticationInfo(new User("xiaoming", "123"), "123", getName());
		return new SimpleAuthenticationInfo("xiaoming", "123", getName());
	}
}
