package org.amazon;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.amazonpojo.PojoAmazon;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Iphone extends BaseClass {
	public static void main(String[] args) {
		launchBrowser();
		loadUrl("https://www.amazon.in/");
		PojoAmazon p = new PojoAmazon();
		type(p.getSearchbox(), "iphone");
		toClick(p.getSearchicon());
		List<WebElement> iPhoneWebElements = driver.findElements(
				By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'iPhone')]"));
		List<String> iPhoneNames = new LinkedList<String>();

		for (WebElement x : iPhoneWebElements) {
			iPhoneNames.add(x.getText());

		}

		System.out.println("Using List" + iPhoneNames);

		Set<String> orderediPhoneNames = new TreeSet<String>();
		orderediPhoneNames.addAll(iPhoneNames);
		System.out.println("Using TreeSet in Alphabetical Order" + orderediPhoneNames);

		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		String iPhoneName;
		String price;
		int intPhonePrice;
		Map<Integer, String> mapProducts = new TreeMap<Integer, String>();
		for (int i = 0; i < iPhoneWebElements.size(); i++)

		{
			iPhoneName = iPhoneWebElements.get(i).getText();// Iterate and Fetch iPhone Name
			price = priceElements.get(i).getText();// Iterate and Fetch iPhone Price
			price = price.replaceAll("[^0-9]", "");// Replace Anything With Space Other than Numbers
			intPhonePrice = Integer.parseInt(price);// Convert to Integer
			mapProducts.put(intPhonePrice, iPhoneName);// Add iPhoneName and Price in TreeMap

		}
		System.out.println("Using Tree Map");
		System.out.println(mapProducts);

	}

}
