package com.scott.design_pattern.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		IUserDao dao = new UserDao();
		
		IUserDao proxyDao = (IUserDao)Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[] { IUserDao.class }, 
				new Test().new ProxyUserDaoHandler(dao));
		
		proxyDao.insertUser(1L, "Ying");
		
		System.out.println(proxyDao.getUserNameById(1L));
		
	}

	private class ProxyUserDaoHandler implements InvocationHandler {
		private IUserDao userDao;

		public ProxyUserDaoHandler(IUserDao userDao) {
			this.userDao = userDao;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			
			System.out.println("proxy before method.");
			Object result = method.invoke(userDao, args);
			System.out.println("proxy after method.");
			
			return result;
		}
	}
}
