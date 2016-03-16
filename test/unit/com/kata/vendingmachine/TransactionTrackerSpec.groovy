package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TransactionTracker)
class TransactionTrackerSpec extends Specification {

	void "TransactionTracker cannot have a negative balance"() {
		when:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: -24).save(flush: true, failOnError: true)

		then:
		thrown(Exception)
	}

	void "given new coin, transactionTotal can be updated"() {
		given:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 0.75).save(flush: true)
		double newTotal = transactionTracker.transactionTotal + 0.25

		expect:
		newTotal == 1.00
	}
}
