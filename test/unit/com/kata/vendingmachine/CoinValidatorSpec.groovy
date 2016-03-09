package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(CoinValidator)
class CoinValidatorSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "given a circumference and weight returnCoinValue will return an integer as the USD value"() {
		given:
		CoinValidator coinValidator = new CoinValidator()

		expect:
		1 == coinValidator.returnCoinValue(1, 1)
	}
}
