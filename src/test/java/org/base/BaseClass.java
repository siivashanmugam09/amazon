package org.base;

import java.awt.AWTException;
import java.awt.GraphicsDevice;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Actions ac;
	public static Alert al;
	public static TakesScreenshot ts;
	public static JavascriptExecutor js;
	public static Select s;
	public static ArrayList<String> a;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void loadUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void toGetTitle() {
		String Title = driver.getTitle();
		System.out.println(Title);
	}

	public static void txtweb(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void type(WebElement element, String values) {
		element.sendKeys(values);
	}

	public static String enterdTxt(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;
	}

	public static void toClick(WebElement element) {
		element.click();
	}

	public static void toquit() {
		driver.quit();
	}

	public static void toMove(WebElement element) {
		ac = new Actions(driver);
		ac.moveToElement(element);
	}

	public static void toDouble(WebElement element) {
		ac = new Actions(driver);
		ac.doubleClick(element);
	}

	public static void toContext(WebElement element) {
		ac = new Actions(driver);
		ac.contextClick(element);
	}

	public static void toDrDp(WebElement src, WebElement dest) {
		ac = new Actions(driver);
		ac.dragAndDrop(src, dest);
	}

	public static void alertAccept() {
		al = driver.switchTo().alert();
		al.accept();
	}

	public static void alertDismiss() {
		al = driver.switchTo().alert();
		al.dismiss();
	}

	public static void alertType(String value) {
		al = driver.switchTo().alert();
		al.sendKeys(value);
	}

	public static void aletGetText() {
		al = driver.switchTo().alert();
		al.getText();
	}

	public static void screenshot(int i) throws IOException {
		ts = (TakesScreenshot) driver;
		File dest = new File("C:\\Users\\rider\\eclipse-workspace\\Amazon\\pictures\\" + i + ".png");
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, dest);
	}

	public static void downScroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public static void upScroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void jsSendkeys(WebElement element, String txt) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value'," + txt + ")", element);
	}

	public static String jsGetValue(WebElement element) {
		js = (JavascriptExecutor) driver;
		String txt = (String) js.executeScript("return arguments[0].getAttribute('value')", element);
		return txt;
	}

	public static void frameId(String id) {
		driver.switchTo().frame(id);
	}

	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}

	public static void frameIndex(int i) {
		driver.switchTo().frame(i);
	}

	public static void frameWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public static void framesSize(String name) {
		List<WebElement> framelist = driver.findElements(By.tagName(name));
		int size = framelist.size();
		System.out.println(size);
	}

	public static void frameParent() {
		driver.switchTo().parentFrame();
	}

	public static void frameDefault() {
		driver.switchTo().defaultContent();
	}

	public static void selectIndex(WebElement element, int i) {
		s = new Select(element);
		s.selectByIndex(i);
	}

	public static void selectText(WebElement element, String value) {
		s = new Select(element);
		s.selectByVisibleText(value);
	}

	public static void selectValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByVisibleText(value);
	}

	public static void multiple(WebElement element) {
		s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}

	public static void optionsGet(WebElement element) {
		s = new Select(element);
		List<WebElement> alloptions = s.getOptions();
		int size = alloptions.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(i);
		}
	}

	public static void allSelectOption(WebElement element) {
		s = new Select(element);
		List<WebElement> allSelected = s.getAllSelectedOptions();
		int size = allSelected.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(i);
		}
	}

	public static void allSelect(WebElement element, int index) {
		s = new Select(element);
		List<WebElement> alloptions = s.getOptions();
		for (int i = 0; i < alloptions.size(); i++) {
			s.selectByIndex(index);
		}
	}

	public static void firstSelect(WebElement element) {
		s = new Select(element);
		WebElement firstSelected = s.getFirstSelectedOption();
		System.out.println(firstSelected);
	}

	public static void deselectIndex(WebElement element, int i) {
		s = new Select(element);
		s.deselectByIndex(i);
	}

	public static void deselectVisibleText(WebElement element, String txt) {
		s = new Select(element);
		s.deselectByVisibleText(txt);
	}

	public static void deselectValue(WebElement element, String value) {
		s = new Select(element);
		s.deselectByValue(value);
	}

	public static void deselect(WebElement element) {
		s = new Select(element);
		s.deselectAll();
	}

	public static void windowId() {
		String windowid = driver.getWindowHandle();
		System.out.println(windowid);
	}

	public static void windowsId() {
		Set<String> windowsid = driver.getWindowHandles();
		int size = windowsid.size();
	}

	public static void switchWindow(int i) {
		Set<String> windowHandles = driver.getWindowHandles();
		a = new ArrayList();
		List<String> listofwindowid = a;
		listofwindowid.addAll(windowHandles);
		String index = listofwindowid.get(i);
		driver.switchTo().window(index);
	}

	public static void enable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}

	public static void display(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}

	public static void select(WebElement element) {
		boolean select = element.isSelected();
		System.out.println(select);
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void toBack() {
		driver.navigate().back();
	}

	public static void toForward() {
		driver.navigate().forward();
	}

	public static void torefresh() {
		driver.navigate().refresh();

	}

	public static void urlnavigate(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();

	}

	public static void excelsheet(String sheetname, int ri, int ci, WebElement element) throws IOException {
		File f = new File(
				"C:\\Users\\rider\\eclipse-workspace\\MavenProject1\\excel\\New Microsoft Excel Worksheet.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(input);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(ri);
		Cell c = r.getCell(ci);
		String stringCellValue = c.getStringCellValue();
		System.out.println(stringCellValue);
		element.sendKeys(stringCellValue);
	}

	public static void excelsheetnumeric(String sheetname, int ri, int ci, WebElement element) throws IOException {
		File f = new File(
				"C:\\Users\\rider\\eclipse-workspace\\MavenProject1\\excel\\New Microsoft Excel Worksheet.xlsx");
		FileInputStream input = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(input);
		Sheet s = w.getSheet(sheetname);
		Row r = s.getRow(ri);
		Cell c = r.getCell(ci);
		double d = c.getNumericCellValue();
		long l = (long) d;
		String value = String.valueOf(l);
		System.out.println(value);
		element.sendKeys(value);

	}

	public static WebElement xpath(String path) {
		WebElement element = driver.findElement(By.xpath(path));
		return element;

	}

	public static WebElement byname(String name) {
		WebElement element = driver.findElement(By.name(name));
		return element;
	}

	public static WebElement byid(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
}
