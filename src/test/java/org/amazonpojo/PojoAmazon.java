package org.amazonpojo;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoAmazon extends BaseClass {
 public PojoAmazon() {
	PageFactory.initElements(driver,this);	
}
 @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
 private WebElement searchbox;
 @FindBy(xpath = "//input[@id='nav-search-submit-button']")
 private WebElement searchicon;
 @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
 private List<WebElement> list;
public WebElement getSearchbox() {
	return searchbox;
}
public WebElement getSearchicon() {
	return searchicon;
}
public List<WebElement> getList() {
	return list;
}
 
}
