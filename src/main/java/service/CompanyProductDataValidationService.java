package service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import entity.BankProductDataDB;
import entity.ProductValueUpdate;
import priceListener.BankPriceListener;
import priceListener.CompanyPriceListener;

public class CompanyProductDataValidationService {
	
	@Autowired
	private BankProductDataDB bankProductData;
	public void validateCompanyProductData(String symbol, double price) {
	LocalDateTime companyUpdateTime=LocalDateTime.now();	
	Optional<ProductValueUpdate> productValueUpdate=bankProductData.getProductValueUpdate(symbol);
	if(!productValueUpdate.isPresent()) {
		System.out.println("Invalid Condition");
		return;
	}
	LocalDateTime bankUpdatetime = productValueUpdate.get().getUpdateTime();
	long updatetimeDuration = Duration.between(bankUpdatetime, companyUpdateTime).toMillis();
	if((updatetimeDuration/1000) >30) {
		System.out.println("Product has no update in 30 secs");
		return;
	}
	double bankPrice = productValueUpdate.get().getPrice();
	if(bankPrice != price) {
		System.out.println("Incorrect Product value update");
		return;
		}
	System.out.println("pass");
	}
	/*public static void main(String[] args) throws InterruptedException {
		ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
		CompanyPriceListener companyPriceListener = context.getBean("companyPriceListener",CompanyPriceListener.class);
		BankPriceListener bankPriceListener = context.getBean("bankPriceListener",BankPriceListener.class);
		bankPriceListener.updatePrice("abc",10.0);
		Thread.sleep(100);
		companyPriceListener.updatePrice("abc",10.0);
	}*/
}
