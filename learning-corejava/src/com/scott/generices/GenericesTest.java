package com.scott.generices;

public class GenericesTest<T> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public static void main(String[] args) {
		GenericesTest<String> gen = new GenericesTest<>();
		gen.setObj("abc");
		// gen.setObj(10); //无法通过编译
		String str = gen.getObj(); // 无需类型转换
		
		// -----------------------------
		GenericesTest gen2 = new GenericesTest();// raw type原始类型
		gen2.setObj("abc");
		gen2.setObj(10); // 可以通过编译，自动装箱将10转化为Integer对象
		Integer num = (Integer) gen2.getObj();// 使用了强制类型转换
	}
}
