package entity;

import java.time.LocalDateTime;

public class ProductValueUpdate {
	double price;
	LocalDateTime updateTime;
	ProductValueUpdate(double price){
		this.price=price;
		this.updateTime=LocalDateTime.now();
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public double getPrice() {
		return price;
	}
}
