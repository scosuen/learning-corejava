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
		// gen.setObj(10); //�޷�ͨ������
		String str = gen.getObj(); // ��������ת��
		
		// -----------------------------
		GenericesTest gen2 = new GenericesTest();// raw typeԭʼ����
		gen2.setObj("abc");
		gen2.setObj(10); // ����ͨ�����룬�Զ�װ�佫10ת��ΪInteger����
		Integer num = (Integer) gen2.getObj();// ʹ����ǿ������ת��
	}
}
