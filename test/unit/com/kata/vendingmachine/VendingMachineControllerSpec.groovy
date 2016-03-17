package com.kata.vendingmachine

import grails.test.mixin.TestFor
import spock.lang.Specification


@TestFor(VendingMachineController)
class VendingMachineControllerSpec extends Specification {

	void "index should call the MachineInitializerService"() {
		given:
		controller.machineInitializerServie = Mock(MachineInitializerService)

		when:
		controller.index()

		then:
		1 * controller.machineInitializerServie.initializeVendingMachine()
	}
}
