package com.kata.vendingmachine

class VendingMachineController {
	def machineInitializerServie

	def index() {
		machineInitializerServie.initializeVendingMachine()
	}
}
