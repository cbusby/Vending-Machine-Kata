package com.kata.vendingmachine

class TransactionTracker {

	double transactionTotal

	static constraints = {
		transactionTotal nullable: false, min: 0.0.toDouble()
	}

	def returnCoins() {
		transactionTotal = 0
		return "INSERT COINS"
	}

	double addCoinToTransactionTotal(Coin coin) {
		transactionTotal = transactionTotal + coin.dollarAmount
	}
}
