package priceListener;

import org.springframework.beans.factory.annotation.Autowired;

import service.CompanyProductDataValidationService;

public class CompanyPriceListener implements PriceListener{
	
	@Autowired
	CompanyProductDataValidationService cmpProductDataVal;
	
	public void updatePrice(String symbol, double price) {		
		cmpProductDataVal.validateCompanyProductData(symbol, price);		
	}

}
