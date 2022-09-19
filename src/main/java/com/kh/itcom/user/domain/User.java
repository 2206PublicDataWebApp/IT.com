package com.kh.itcom.user.domain;

import java.sql.Date;

public class User {
	private String userId;
	private String userPw;
	private String userEmail;
	private String newEmail;
	private String authentication;
	private String userLevel;
	private int userPoint;
	private Date joinDate;
	private String withdrawal;
	private Date withdrawDate;

	public User() {
	}

	/**
	 * 로그인
	 * @param userId
	 * @param userPw
	 */
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	/**
	 * 회원가입
	 * @param userId
	 * @param userPw
	 * @param userEmail
	 */
	public User(String userId, String userPw, String userEmail) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(String withdrawal) {
		this.withdrawal = withdrawal;
	}

	public Date getWithdrawDate() {
		return withdrawDate;
	}

	public void setWithdrawDate(Date withdrawDate) {
		this.withdrawDate = withdrawDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", newEmail=" + newEmail
				+ ", authentication=" + authentication + ", userLevel=" + userLevel + ", userPoint=" + userPoint
				+ ", joinDate=" + joinDate + ", withdrawal=" + withdrawal + ", withdrawDate=" + withdrawDate + "]";
	}

}
