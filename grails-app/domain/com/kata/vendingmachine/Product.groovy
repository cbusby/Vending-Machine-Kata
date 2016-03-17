package com.kata.vendingmachine

class Product {

	int stock
	int price

	static constraints = {
		stock nullable: false
		price nullable: false, min: 0
	}
}
