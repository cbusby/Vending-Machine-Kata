package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(CoinValidator)
@Mock(Coin)
class CoinValidatorSpec extends Specification {
	void "given a penny circumference and weight, returnCoinValue will return 0.0USD as a penny is not valid"() {
		given:
		CoinValidator coinValidator = new CoinValidator()

		expect:
		0 == coinValidator.returnCoinValue(19.05, 2.5)
	}

	void "given a valid quarter circumference and weight, returnCoinValue will return 0.25USD"() {
		given:
		new Coin(circumference: 24.26, weight: 5.67, centAmount: 25).save(flush: true)
		CoinValidator coinValidator = new CoinValidator()

		expect:
		25 == coinValidator.returnCoinValue(24.26, 5.67)
	}

	void "given a valid dime circumference and weight, returnCoinValue will return 0.10USD"() {
		given:
		new Coin(circumference: 17.91, weight: 2.268, centAmount: 10).save(flush: true)
		CoinValidator coinValidator = new CoinValidator()

		expect:
		10 == coinValidator.returnCoinValue(17.91, 2.268)
	}

	void "given a valid coin, returnCoinValue will increment the stock of that coin"() {
		given:
		Coin coin = new Coin(weight: 1, circumference: 1, centAmount: 1).save(flush: true)
		CoinValidator coinValidator = new CoinValidator()
		coinValidator.returnCoinValue(1, 1)

		expect:
		coin.stock == 1
	}
}
