package com.kata.vendingmachine

class Coin {
	double weight
	double circumference
	double dollarAmount
	int stock = 0

	static constraints = {
		weight nullable: false, min: 0.0.toDouble()
		circumference nullable: false, min: 0.0.toDouble()
		dollarAmount nullable: false, min: 0.0.toDouble()
		stock nullable: false
	}
}
