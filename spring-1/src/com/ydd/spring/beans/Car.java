package com.ydd.spring.beans;

public class Car {
	
	private String brand;
	private String name;
	private double price;
	private int maxspeed;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getMaxspeed() {
		return maxspeed;
	}

	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}

	public Car(String brand, String name, double price) {
		super();
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	public Car(String brand, String name, int maxspeed) {
		super();
		this.brand = brand;
		this.name = name;
		this.maxspeed = maxspeed;
	}

	@Override
	public String toString() {
		return "car [brand=" + brand + ", name=" + name + ", price=" + price + ", maxspeed=" + maxspeed + "]";
	}
	
	
	
}
