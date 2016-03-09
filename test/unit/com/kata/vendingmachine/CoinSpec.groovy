package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Coin)
class CoinSpec extends Specification {

	def setup() {
	}

	def cleanup() {
	}

	void "coin is valid when all inputs are given"() {
		given:
		Coin coin = new Coin(weight: 1.0, circumference: 1.0, dollarAmount: 1.0)

		expect:
		coin.validate()
	}
}
