package com.kata.vendingmachine

class ProductDispenser {

	static constraints = {
	}

	boolean dispenseItem(Long productId) {
		Product product = Product.findById(productId)
		if(product?.stock > 0) {
			product.stock--
			return true
		}

		return false
	}
}
