package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TransactionTracker)
@Mock(Coin)
class TransactionTrackerSpec extends Specification {

	void "TransactionTracker cannot have a negative balance"() {
		when:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: -24).save(flush: true, failOnError: true)

		then:
		thrown(Exception)
	}

	void "given new coin, transactionTotal can be updated"() {
		given:
		Coin quarter = new Coin(weight: 2, circumference: 2, dollarAmount: 0.25, stock: 3).save(flush: true)
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 0.75).save(flush: true)

		when:
		Coin nickel = new Coin(weight: 2, circumference: 2, dollarAmount: 0.05, stock: 1).save(flush: true)
		transactionTracker.addCoinToTransactionTotal(nickel)

		then:
		transactionTracker.transactionTotal == 0.80
	}

	void "given coin return triggered, transaction total should be 0USD"() {
		given:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 1.25).save(flush: true)

		when:
		transactionTracker.returnCoins()

		then:
		transactionTracker.transactionTotal == 0.00
	}
}
