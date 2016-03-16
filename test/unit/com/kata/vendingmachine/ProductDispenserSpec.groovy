package com.kata.vendingmachine

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ProductDispenser)
@Mock(Product)
class ProductDispenserSpec extends Specification {

	void "given chips are selected, the ProductDispenser will dispense chips"() {
		given:
		Product chips = new Product(stock: 1, price: 0.50).save(flush: true)
		ProductDispenser productDispenser = new ProductDispenser()

		expect:
		true  == productDispenser.dispenseItem(chips.id)
	}

	void "given soda is selected but there is no stock, the ProductDispenser will not dispense soda"() {
		given:
		Product soda = new Product(stock: 0, price: 1.00).save(flush: true)
		ProductDispenser productDispenser = new ProductDispenser()

		expect:
		false == productDispenser.dispenseItem(soda.id)
	}
}
