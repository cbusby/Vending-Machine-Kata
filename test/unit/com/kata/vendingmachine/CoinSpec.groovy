package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Coin)
class CoinSpec extends Specification {
	void "coin is valid when all inputs are given"() {
		given:
		Coin coin = new Coin(weight: 1.0, circumference: 1.0, centAmount: 1)

		expect:
		coin.validate()
	}

	void "coin cannot be created with negative inputs"() {
		when:
		new Coin(weight: -1.0, circumference: -1.0, centAmount: -1).save(flush: true, failOnError: true)

		then:
		thrown(Exception)
	}

	void "a coin has a stock of zero when created"() {
		given:
		Coin coin = new Coin(weight: 1.0, circumference: 1.0, centAmount: 1).save(flush: true)

		expect:
		coin.stock == 0
	}
}
