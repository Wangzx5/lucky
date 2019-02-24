package com.winter.model.power;

public class LoginUser {
    private String userId;

    private String userName;

    private String userPassword;

    private String userRoleId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

	@Override
	public String toString() {
		return "LoginUser [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userRoleId=" + userRoleId + "]";
	}
    
    
    
}