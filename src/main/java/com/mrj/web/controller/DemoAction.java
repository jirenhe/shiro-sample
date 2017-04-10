package com.mrj.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	
	
	@RequestMapping("/login")
	public String login(String username,  String password, String remeberme){
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()){
			return "redirect:/demo/index";
		}else{
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe("1".equals(remeberme) ? true : false);
			try {
				subject.login(token);
				return "redirect:/demo/index";
			} catch (AuthenticationException e) {
				return "login";
			}
		}
	}
	
	@RequestMapping("/loginOut")
	public String loginOut(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "login";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@RequestMapping("/checkPermission1")
	@ResponseBody
	public String checkPermission1(String permission){
		Subject subject = SecurityUtils.getSubject();
		return subject.isPermitted(permission) ? "1" : "0";
	}
	
	@RequestMapping("/checkPermission2")
	@RequiresPermissions("user:delete")
	public String checkPermission2(){
		return "sucess";
	}
	
	@RequestMapping("/checkPermission3")
	@RequiresPermissions("whatever")
	public String checkPermission3(){
		return "sucess";
	}
}
