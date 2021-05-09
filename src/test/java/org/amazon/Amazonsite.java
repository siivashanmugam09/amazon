package org.amazon;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazonsite extends BaseClass {
public static void main(String[] args) throws InterruptedException {
	launchBrowser();
	loadUrl("https://www.amazon.in/");
	WebElement searchbox = xpath("//input[@id='twotabsearchtextbox']");
	type(searchbox, "iphone");
	WebElement searchicon = xpath("//input[@id='nav-search-submit-button']");
	toClick(searchicon);
	List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	int number = list.size();
	System.out.println("Number of iphone listed="+number);
	WebElement iphone11 = xpath("(//span[text()='New Apple iPhone 11 (128GB) - Purple'])[1]");
	toClick(iphone11);
	switchWindow(1);
	WebElement price = xpath("(//span[@class='a-color-price'])[3]");
	String rate = price.getText();
	System.out.println("price:"+rate);
	WebElement cart = xpath("//input[@name='submit.add-to-cart']");
	toClick(cart);
	Thread.sleep(5000);
	WebElement cart2 = xpath("(//input[@class='a-button-input'])[1]");
	toClick(cart2);
	WebElement buy = xpath("//input[@name='proceedToRetailCheckout']");
	toClick(buy);
	WebElement userid = xpath("//input[@name='email']");
	type(userid, "9566596524");
	WebElement contin = xpath("//input[@id='continue']");
	toClick(contin);
	
}
}
