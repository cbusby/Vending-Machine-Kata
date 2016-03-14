package com.kata.vendingmachine

class Product {

	int stock
	double price

	static constraints = {
		stock nullable: false
		price nullable: false, min: 0.0.toDouble()
	}
}
