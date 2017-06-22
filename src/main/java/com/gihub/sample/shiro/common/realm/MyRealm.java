package com.gihub.sample.shiro.common.realm;

import java.util.List;

import com.gihub.sample.shiro.vo.PermissionVo;
import com.gihub.sample.shiro.vo.RoleVo;
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

import com.gihub.sample.shiro.po.User;
import com.gihub.sample.shiro.service.RoleService;
import com.gihub.sample.shiro.service.UserService;

/**
 * @author ��Administrator
 * @modified:
 * ��Administrator(2017��2��25�� ����3:53:28): <br>
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
	//�жϴ�Realm�Ƿ�֧�ִ�Token
	public boolean supports(AuthenticationToken token) {
		return token instanceof UsernamePasswordToken;
	}


	@Override
	//�û���֤�󡣸��û���Ȩ(��checkPermission��isPermitted��������ʱ�Ż����)
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
	//�û���֤�������������ж��û��Ƿ���Ե���Ĳ���
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
			//���������֤�ɹ�����֤��Ϣ
			return new SimpleAuthenticationInfo(userId, password, getName());
		}else{
			throw new UnknownAccountException("login error: wrong username or password ["
					+ userId + "]");
		}
	}
	
}
