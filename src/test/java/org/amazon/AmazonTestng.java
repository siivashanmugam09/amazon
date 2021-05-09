package org.amazon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.amazonpojo.PojoAmazon;
import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTestng extends BaseClass {
	@BeforeMethod
	private void browser() {
		launchBrowser();
		loadUrl("https://www.amazon.in/");
	}

	@Test
	private void tc1() throws InterruptedException, IOException {
		PojoAmazon p = new PojoAmazon();
		type(p.getSearchbox(), "iphone");
		toClick(p.getSearchicon());
		List<WebElement> priceofproduct = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		WebElement remove = priceofproduct.remove(0);

		List<WebElement> productname = driver.findElements(
				By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'and contains(text(),'iPhone')]"));

		int size = productname.size();
		System.out.println("No_of_product_listed=" + size + "\n");
		implicitWait();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < productname.size(); i++) {
			String name = productname.get(i).getText();
			String price = priceofproduct.get(i).getText();
			String replace = price.replace(",", "");
			int rate = Integer.parseInt(replace);
			map.put(name, rate);

		}
		Set<String> model = map.keySet();
		Collection<Integer> mrp = map.values();
		ArrayList<String> keyList = new ArrayList<String>(model);
		ArrayList<Integer> valueList = new ArrayList<Integer>(mrp);
		for (int i = 0; i < keyList.size(); i++) {
			System.out.println(keyList.get(i) + "=" + valueList.get(i) + "\n");

		}
		for (int i = 0; i < productname.size(); i++) {
			String name = productname.get(i).getText();
			if (name.equals("New Apple iPhone 11 (128GB) - Purple")) {
				toClick(productname.get(i));

			}

		}

		for (int i = 1; i < 3; i++) {
			Set<String> allWindowId = driver.getWindowHandles();
			List<String> listofWindowId = new ArrayList<String>();
			listofWindowId.addAll(allWindowId);
			driver.switchTo().window(listofWindowId.get(0));
			toClick(productname.get(i));
			Thread.sleep(5000);
			screenshot(i);
			Thread.sleep(2000);

		}
//		Scanner s = new Scanner(System.in);
//		System.out.println("enter the position of product");
//		int no = s.nextInt();
//		int j = no-1;
//		WebElement selectproduct = productname.get(j);
//		toClick(selectproduct);

	}
}
