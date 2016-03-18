package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MachineInitializerService)
@Mock([Coin, CoinValidator, Product, ProductDispenser, TransactionTracker, VendingMachine])
class MachineInitializerServiceSpec extends Specification {

	void "initializeCoins should create the valid coins"() {
		given:
		service.initializeCoins()

		expect:
		Coin.getAll().size() == 3
	}

	void "initializeProducts should create the current products"() {
		given:
		service.initializeProducts()

		expect:
		Product.getAll().size() == 3
	}

	void "initializeVendingMachine creates the classes that do work"() {
		given:
		service.initializeVendingMachine()

		expect:
		CoinValidator.getAll().size() == 1
		ProductDispenser.getAll().size() == 1
		TransactionTracker.getAll().size() == 1
		VendingMachine.getAll().size() == 1
	}

	void "initializeVendingMachine will not instantiate if a machine is already created"() {
		given:
		VendingMachine vendingMachine = new VendingMachine().save(flush: true)

		when:
		service.initializeVendingMachine()

		then:
		VendingMachine.getAll().size() == 1
	}
}
