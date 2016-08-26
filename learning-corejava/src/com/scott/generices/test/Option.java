package com.scott.generices.test;

public class Option<T> implements IValueProvider<T> {

	private T value;

	public Option() {

	}

	public Option(boolean flag, T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		if (value == null)
			throw new IllegalAccessError();

		return value;
	}

	public static <T> Option<T> createEmptyOption() {
		return new Option<T>();
	}

	public boolean hasValue() {
		if (value == null)
			return false;

		return true;
	}

	public static <T> Option<T> fromValue(T value) {
		return new Option<T>(true, value);
	}

	public T valueOrElse(IValueProvider<T> valueProvider) {
		if (value == null)
			return valueProvider.getValue();

		return value;
	}

	@Override
	public boolean equals(Object obj) {

		T otherObj = null;
		try {
			otherObj = (T) ((Option) obj).getValue();
		} catch (IllegalAccessError e) {
		}

		if (value == null && otherObj == null)
			return true;

		if (value == null || otherObj == null)
			return false;

		if (value.equals(otherObj))
			return true;

		return false;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
