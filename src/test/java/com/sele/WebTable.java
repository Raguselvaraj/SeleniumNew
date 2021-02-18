package com.sele;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().maximize();

		WebElement table = driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[8]"));
		table.click();

		List<WebElement> tableCount = driver.findElements(By.xpath("(//div[@class=' container table'])[1]"));
		for (int i = 0; i < tableCount.size(); i++) {
			WebElement webElement = tableCount.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}

		List<WebElement> rows = driver.findElements(By.tagName("th"));
		int size = rows.size();
		System.out.println("Total rows::" + size);

		List<WebElement> columns = driver.findElements(By.tagName("tr"));
        int size2 = columns.size();
        System.out.println("Total Columns::"+size2);
	
        WebElement percentage = driver.findElement(By.xpath("//td[normalize-space()='Learn to interact using Keyboard, Actions']//following::td[1]"));
        String text = percentage.getText();
        System.out.println(text);
        
	    List<WebElement> comparing = driver.findElements(By.tagName("//td[2]"));
	    
	    List<Integer> l=new ArrayList<Integer>();
	    
	    for (int i = 0; i <comparing.size(); i++) {
			WebElement webElement = comparing.get(i);
		    String text2 = webElement.getText();
	        String replace = text.replace("%", "");
	        l.add(Integer.parseInt(replace));
	    }
	    
	    System.out.println("percentage removed values"+l);
	    
	    
	    
	
	
	
	}

}