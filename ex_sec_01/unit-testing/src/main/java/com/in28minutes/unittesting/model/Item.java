package com.in28minutes.unittesting.model;

public class Item {

	private int id;
	private String name;
	private int price;
	private int quantity;

	public Item(int id, String name, int price, int quatity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quatity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Item[%d, %s, %d, %d]", id, name, price, quantity);
	}
}
