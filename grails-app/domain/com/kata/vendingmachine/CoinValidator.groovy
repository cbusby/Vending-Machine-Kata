package com.kata.vendingmachine

class CoinValidator {

	static constraints = {
	}

	int returnCoinValue(double circumference, double weight) {
		Coin coin = Coin.findByCircumferenceAndWeight(circumference, weight)

		if (!coin) {
			return 0
		} else {
			coin.stock++
			return coin.centAmount
		}
	}
}
