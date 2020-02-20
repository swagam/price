package price;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import priceListener.BankPriceListener;
import priceListener.CompanyPriceListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/bean.xml"})
public class CompanyProductDataValidationServiceTest {
	
	@Autowired
	CompanyPriceListener companyPriceListener;
	
	@Autowired
	BankPriceListener bankPriceListener;
	
	@Test
	public void InvalidProductUdateFromCompany() throws InterruptedException {
		bankPriceListener.updatePrice("abc",10.0);
		Thread.sleep(100);
		companyPriceListener.updatePrice("abdc",10.0);
	}
	
	@Test
	public void OldProductUdateFromCompany() throws InterruptedException {
		bankPriceListener.updatePrice("abc",10.0);
		Thread.sleep(40000);
		companyPriceListener.updatePrice("abc",10.0);
	}
	
	@Test
	public void CorrectProductUdateFromCompany() throws InterruptedException {
		bankPriceListener.updatePrice("abc",10.0);
		Thread.sleep(20000);
		companyPriceListener.updatePrice("abc",10.0);
	}
}
