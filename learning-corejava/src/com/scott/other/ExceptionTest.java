package com.scott.other;

public class ExceptionTest {

	public static void main(String[] args) {
//		uncheckedExceptionTest1();
		
		checkedExceptionTest1();

	}

	public static void uncheckedExceptionTest1() {
		 uncheckedExceptionTest2();

		/*try {
			uncheckedExceptionTest2();
		} catch (UncheckedException ex) {
			System.out.println(ex.getMessage());
		}*/
	}

	public static void uncheckedExceptionTest2() {
		uncheckedExceptionTest3();
	}

	public static void uncheckedExceptionTest3() {
		throw new UncheckedException("ying");
	}

	public static void checkedExceptionTest1() {
		checkedExceptionTest2();
	}

	public static void checkedExceptionTest2() {
		checkedExceptionTest3();
	}

	public static void checkedExceptionTest3() {
		try {
			throw new CheckedException(" checked exception ");
		} catch (CheckedException e) {
			e.printStackTrace();
		}
	}

}

class UncheckedException extends RuntimeException {

	public UncheckedException() {
		super();
	}

	public UncheckedException(String msg) {
		super(msg);
	}
}

class CheckedException extends Exception {
	public CheckedException() {
		super();
	}

	public CheckedException(String msg) {
		super(msg);
	}
}
