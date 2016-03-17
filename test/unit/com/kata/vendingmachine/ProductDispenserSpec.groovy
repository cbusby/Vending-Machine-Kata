package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(ProductDispenser)
@Mock(Product)
class ProductDispenserSpec extends Specification {

	void "given chips are selected, the ProductDispenser will dispense chips"() {
		given:
		Product chips = new Product(stock: 1, price: 0.50).save(flush: true)
		ProductDispenser productDispenser = new ProductDispenser()

		expect:
		true  == productDispenser.dispenseItem(chips.id)
		chips.stock == 0
	}

	void "given soda is selected but there is no stock, the ProductDispenser will not dispense soda"() {
		given:
		Product soda = new Product(stock: 0, price: 1.00).save(flush: true)
		ProductDispenser productDispenser = new ProductDispenser()

		expect:
		false == productDispenser.dispenseItem(soda.id)
	}

	void "given invalid input, the ProductDispenser will not dispense a product"() {
		given:
		ProductDispenser productDispenser = new ProductDispenser()

		expect:
		false == productDispenser.dispenseItem(1)
	}
}
