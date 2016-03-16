package com.kata.vendingmachine

class TransactionTracker {

	double transactionTotal

	static constraints = {
		transactionTotal nullable: false, min: 0.0.toDouble()
	}
}
