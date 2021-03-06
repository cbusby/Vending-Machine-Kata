package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(Product)
class ProductSpec extends Specification {
	void "a product cannot be created with a negtive price"() {
		when:
		Product product = new Product(stock: 0, price: -100).save(flush: true, failOnError: true)

		then:
		thrown(Exception)
	}

	void "a product can be created without a name"() {
		when:
		new Product(stock: 0, price: 0).save(flush: true, failOnError: true)

		then:
		notThrown(Exception)
	}
}
