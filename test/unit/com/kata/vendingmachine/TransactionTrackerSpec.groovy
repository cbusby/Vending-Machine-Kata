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
}
