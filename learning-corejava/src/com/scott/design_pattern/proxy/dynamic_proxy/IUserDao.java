package com.scott.design_pattern.proxy.dynamic_proxy;

import java.util.HashMap;
import java.util.Map;

public interface IUserDao {
	
	static Map<Long, String> USER_MAP = new HashMap<Long, String>();
	
	String getUserNameById (Long userId);
	boolean insertUser (Long userId, String username);

}
