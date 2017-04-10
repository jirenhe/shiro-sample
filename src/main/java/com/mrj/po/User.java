package com.mrj.po;

import com.mrj.po.base.BasePo;

public class User extends BasePo{
	
    private String userid;

    private String username;

    private String password;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public String getMapperNameSpace() {
		return "com.mrj.dao.UserMapper";
	}
    
}