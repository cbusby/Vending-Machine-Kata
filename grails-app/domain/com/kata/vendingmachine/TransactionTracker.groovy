package com.kata.vendingmachine

class TransactionTracker {

	int transactionTotal

	static constraints = {
		transactionTotal nullable: false, min: 0
	}

	def returnCoins() {
		if(transactionTotal > 0) {
			Coin.getAll().each { coin ->
				int coinsToReturnCount = transactionTotal.intdiv(coin.centAmount)
				coin.stock = coin.stock - coinsToReturnCount
				transactionTotal = transactionTotal - coin.centAmount * coinsToReturnCount
				coin.save(flush: true)
			}
		}


		transactionTotal = 0
		return "INSERT COINS"
	}

	double addCoinToTransactionTotal(Coin coin) {
		transactionTotal = transactionTotal + coin.centAmount
	}
}
