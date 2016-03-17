package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(MachineInitializerService)
@Mock([Coin, CoinValidator, Product, ProductDispenser, TransactionTracker, VendingMachine])
class MachineInitializerServiceSpec extends Specification {

	void "initializeVendingMachine should create the valid coins"() {
		given:
		service.initializeVendingMachine()

		expect:
		Coin.getAll().size() == 3
	}
}
