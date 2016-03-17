package com.kata.vendingmachine

import grails.transaction.Transactional

@Transactional
class MachineInitializerService {

	def initializeVendingMachine() {
		new Coin(circumference: 24.26, weight: 5.67, centAmount: 25).save(flush: true)
		new Coin(circumference: 17.91, weight: 2.268, centAmount: 10).save(flush: true)
		new Coin(circumference: 21.21, weight: 5.0, centAmount: 5).save(flush: true)
		new Product(price: 100, stock: 2).save(flush: true)
		new Product(price: 65, stock: 2).save(flush: true)
		new Product(price: 50, stock: 2).save(flush: true)
		CoinValidator coinValidator = new CoinValidator().save(flush: true)
		ProductDispenser productDispenser = new ProductDispenser().save(flush: true)
		TransactionTracker transactionTracker = new TransactionTracker().save(flush: true)
		VendingMachine vendingMachine = new VendingMachine(
				coinValidator: coinValidator,
				productDispenser: productDispenser,
				transactionTracker: transactionTracker
		).save(flush: true)
	}
}
