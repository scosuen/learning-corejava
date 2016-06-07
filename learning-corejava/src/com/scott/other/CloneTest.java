package com.scott.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CloneTest {

	public static void main(String[] args) throws Exception {
		CloneableUser u1 = new CloneableUser();
		u1.setUserId(1);
		u1.setUserName("ying");
		u1.setSalary(new BigDecimal(300.5));
		u1.setAddress(new Address("Queen Mary", "H3H3W2"));
		u1.setFriends(new ArrayList<String>() {
			{
				add("Scott");
				add("Sun");
			}
		});

		Cloneable u2 = (CloneableUser) u1.deepClone();
		System.out.println("u2: " + u2);
		System.out.println("u1: " + u1);

		u1.setUserName("ying111");
		u1.setUserId(2);
		u1.getFriends().add("Stone");
		u1.getAddress().setStreet("ch");

		System.out.println("u2: " + u2);
		System.out.println("u1: " + u1);
		
		
	}

}

class CloneableUser implements Cloneable, Serializable {

	private int userId;
	private String userName;
	private BigDecimal salary;
	private Address address;
	private List<String> friends;

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		CloneableUser newOne = (CloneableUser) super.clone();
		newOne.address = (Address) getAddress().clone();

		return newOne;
	}
	
	public Object deepClone() throws IOException, ClassNotFoundException {
		// 将对象写到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(this);
		// 从流里读出来
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return (oi.readObject());
	}

}

class Address implements Cloneable, Serializable {
	private String street;
	private String zip;

	public Address() {

	}

	public Address(String street, String zip) {
		this.street = street;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
