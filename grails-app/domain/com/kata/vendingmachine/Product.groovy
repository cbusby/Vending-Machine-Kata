package com.kata.vendingmachine

class Product {

	String name
	int stock
	int price

	static constraints = {
		name nullable: true
		stock nullable: false
		price nullable: false, min: 0
	}
}
