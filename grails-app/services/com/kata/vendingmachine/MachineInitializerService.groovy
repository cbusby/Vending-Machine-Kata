package com.kata.vendingmachine

import grails.transaction.Transactional

@Transactional
class MachineInitializerService {

	def initializeVendingMachine() {
		Coin quarter = new Coin(circumference: 24.26, weight: 5.67, centAmount: 25).save(flush: true)
		Coin dime = new Coin(circumference: 17.91, weight: 2.268, centAmount: 10).save(flush: true)
		Coin nickel = new Coin(circumference: 21.21, weight: 5.0, centAmount: 5).save(flush: true)
	}
}
