package com.flipkart.ecommerce_backend.api.models;

public class PasswordResetBody {
	
	private String token;
	
	private String newPassword;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
