package com.scott.other;

public class HashCodeTest {
	private static User user1 = new User(1L, "Ying");
	private static User user2 = new User(1L, "Sun");
	
	public static void main(String[] args) {
		test1 ();
	}
	
	public static int test1 () {
		System.out.println(user1.hashCode());
		System.out.println(user2.hashCode());
		
		return 0;
	}

	private static class User {
		private Long userId;
		private String username;
		
		public User (Long userId, String username) {
			this.userId = userId;
			this.username = username;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		@Override
		public int hashCode() {
			return getUserId().hashCode();
		}
	}
}
