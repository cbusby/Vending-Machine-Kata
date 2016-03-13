package com.kata.vendingmachine

import java.lang.reflect.Array


class CoinValidator {

	static constraints = {
	}

	double returnCoinValue(double circumference, double weight) {
		Coin coin = Coin.findByCircumferenceAndWeight(circumference, weight)

		if (!coin) {
			return 0.0
		} else {
			return coin.dollarAmount
		}
	}
}
