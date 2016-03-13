package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(CoinValidator)
@Mock(Coin)
class CoinValidatorSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "given a penny circumference and weight, returnCoinValue will return 0.0USD as a penny is not valid"() {
		given:
		CoinValidator coinValidator = new CoinValidator()

		expect:
		0.0 == coinValidator.returnCoinValue(19.05, 2.5)
	}

	void "given a valid quarter circumference and weight, returnCoinValue will return 0.25USD"() {
		given:
		Coin quarter = new Coin(circumference: 24.26, weight: 5.67).save(flush: true)
		CoinValidator coinValidator = new CoinValidator()

		expect:
		0.25 == coinValidator.returnCoinValue(24.26, 5.67)
	}
}
