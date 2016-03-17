package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TransactionTracker)
@Mock(Coin)
class TransactionTrackerSpec extends Specification {

	void "TransactionTracker cannot have a negative balance"() {
		when:
		new TransactionTracker(transactionTotal: -24).save(flush: true, failOnError: true)

		then:
		thrown(Exception)
	}

	void "TransactionTracker total is initially 0USD"() {
		when:
		TransactionTracker transactionTracker = new TransactionTracker()

		then:
		transactionTracker.transactionTotal == 0
	}

	void "given new coin, transactionTotal can be updated"() {
		given:
		new Coin(weight: 2, circumference: 2, centAmount: 25, stock: 3).save(flush: true)
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 75).save(flush: true)

		when:
		Coin nickel = new Coin(weight: 2, circumference: 2, centAmount: 5, stock: 1).save(flush: true)
		transactionTracker.addCoinToTransactionTotal(nickel)

		then:
		transactionTracker.transactionTotal == 80
	}

	void "given returnCoins triggered, transaction total should be 0USD"() {
		given:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 1.25).save(flush: true)

		when:
		transactionTracker.returnCoins()

		then:
		transactionTracker.transactionTotal == 0
	}

	void "given returnCoins is triggered and the user has not inserted coins, it prints insert coin"() {
		when:
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 0).save(flush: true)

		then:
		transactionTracker.returnCoins() == "INSERT COINS"
	}

	void "given coin return is triggered, returnCoins reduces the stock of coins according to the value of the transaction total"() {
		given:
		Coin quarter = new Coin(weight: 2, circumference: 2, centAmount: 25, stock: 2).save(flush: true)
		Coin dime = new Coin(weight: 2, circumference: 2, centAmount: 10, stock: 2).save(flush: true)
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 35).save(flush: true)

		when:
		transactionTracker.returnCoins()

		then:
		quarter.stock == 1
		dime.stock == 1
	}

	void "given the machine has no coins in stock, and the user inserts a coin, returnCoins returns the coin"() {
		given:
		Coin quarter = new Coin(weight: 2, circumference: 2, centAmount: 25, stock: 1).save(flush: true)
		TransactionTracker transactionTracker = new TransactionTracker(transactionTotal: 25).save(flush: true)

		when:
		transactionTracker.returnCoins()

		then:
		quarter.stock == 0
	}
}
