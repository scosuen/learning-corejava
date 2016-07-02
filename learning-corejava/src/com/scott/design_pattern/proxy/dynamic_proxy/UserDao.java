package com.scott.design_pattern.proxy.dynamic_proxy;

public class UserDao implements IUserDao {
	
	@Override
	public String getUserNameById(Long userId) {
		return USER_MAP.get(userId);
	}

	@Override
	public boolean insertUser(Long userId, String username) {
		if (getUserNameById(userId) != null)
			return false;
		
		USER_MAP.put(userId, username);
		return true;
	}

}
