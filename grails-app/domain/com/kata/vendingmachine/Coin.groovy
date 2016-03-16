package com.kata.vendingmachine

class Coin {
	double weight
	double circumference
	int centAmount
	int stock = 0

	static constraints = {
		weight nullable: false, min: 0.0.toDouble()
		circumference nullable: false, min: 0.0.toDouble()
		centAmount nullable: false, min: 0
		stock nullable: false
	}
}
