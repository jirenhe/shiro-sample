package com.mrj.common.realm;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.mrj.po.User;
import com.mrj.service.RoleService;
import com.mrj.service.UserService;
import com.mrj.vo.PermissionVo;
import com.mrj.vo.RoleVo;

/**
 * @author ★Administrator
 * @modified:
 * ☆Administrator(2017年2月25日 下午3:53:28): <br>
 */
public class MyRealm extends AuthorizingRealm {
	
	private Logger logger = Logger.getLogger(MyRealm.class);
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Override
	public String getName() {
		return "MyRealm";
	}

	@Override
	//判断此Realm是否支持此Token
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}


	@Override
	//用户认证后。给用户授权(在checkPermission或isPermitted方法调用时才会调用)
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		String userID = principalCollection.getPrimaryPrincipal().toString();
		List<RoleVo> roleList = roleService.finRoleByUserId(userID);
		if(roleList != null && roleList.size() > 0){
			List<PermissionVo> permissionList = null;
			for (RoleVo roleVo : roleList) {
				info.addRole(roleVo.getRolename());
				permissionList = roleVo.getPermissions();
				if(permissionList != null && permissionList.size() > 0){
					for (PermissionVo permissionVo : permissionList) {
						info.addStringPermission(permissionVo.getPermissionname());
					}
				}
			}
		}
		return info;
	}

	@Override
	//用户认证。可以用来做判断用户是否可以登入的操作
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String password = new String(upToken.getPassword());
		String userId = token.getPrincipal().toString();
		logger.debug("userId    	"+userId);
		logger.debug("password      "+password);
		User user = userService.finUserByPrimaryKey(userId);
		if(user != null && user.getPassword().equals(password)){
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("userId", token.getPrincipal());
			//返回身份验证成功的认证信息
			return new SimpleAuthenticationInfo(userId, password, getName());
		}else{
			throw new UnknownAccountException("login error: wrong username or password ["
					+ userId + "]");
		}
	}
	
}
