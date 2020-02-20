package priceListener;

import org.springframework.beans.factory.annotation.Autowired;

import entity.BankProductDataDB;

public class BankPriceListener implements PriceListener {
	
	@Autowired
	private BankProductDataDB productData;
	public void updatePrice(String symbol, double price) {
		productData.updateProductData(symbol, price);		
	}
	
}
