package entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankProductDataDB {
	private Map <String,ProductValueUpdate> bankProductDataMap = new HashMap<String, ProductValueUpdate>();
	public Map <String,ProductValueUpdate> getBankproductDataMap(){
		return bankProductDataMap;
	}
	public void updateProductData(String symbol, double price) {
		bankProductDataMap.put(symbol,new ProductValueUpdate(price));
	}
	public Optional<ProductValueUpdate> getProductValueUpdate(String symbol) {
		return Optional.ofNullable(bankProductDataMap.get(symbol));
	}
}
