package com.scott.innerclass;

public class OuterClass {
	
	class InnerClass {
		private String innerString = "Im inner class";

		public String getInnerString() {
			return innerString;
		}

		public void setInnerString(String innerString) {
			this.innerString = innerString;
		}
	}
	
	public InnerClass getInnerInstance () {
		return new InnerClass();
	}
}

