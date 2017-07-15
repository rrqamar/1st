package com.project.automationPrac.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.selenium.library.BasePage;

public class WomenPage extends BasePage {

	/***
	 * This will get css valve as input string, for wait verify page load
	 * 
	 * @param cssString
	 * @return
	 */
	public WomenPage waitUntilPageLoad(String cssString) {
		WebElement elemnt = myLib.fluentWait(By.cssSelector(cssString));
		Assert.assertNotNull(elemnt);
		return this;
	}

	/***
	 * this method select size of dress for small (s or S), for Medium(m or M),
	 * for large(l or L)
	 * 
	 * @param s,m,l
	 * @return
	 */
	public WomenPage selectSize(String size) {
		if (size == "s" || size == "S") {
			WebElement dressSize = driver.findElement(By.id("uniform-layered_id_attribute_group_1"));
			dressSize.click();
		} else if (size == "m" || size == "M") {
			WebElement dressSize = driver.findElement(By.id("uniform-layered_id_attribute_group_2"));
			dressSize.click();

		} else if (size == "l" || size == "L") {
			WebElement dressSize = driver.findElement(By.id("uniform-layered_id_attribute_group_3"));
			dressSize.click();

		}

		return this;
	}

	public WomenPage dressColor(String color) {
		if (color == "Beige" || color == "Be") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_7"));
			dressClr.click();
		}
		if (color == "White" || color == "Wh") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_8"));
			dressClr.click();
		}
		if (color == "Black" || color == "Bl") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_11"));
			dressClr.click();
		}
		if (color == "Orange" || color == "Or") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_13"));
			dressClr.click();
		}
		if (color == "Blue" || color == "Bl") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_14"));
			dressClr.click();
		}
		if (color == "Green" || color == "Gr") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_15"));
			dressClr.click();
		}
		if (color == "Yellow" || color == "Ye") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_16"));
			dressClr.click();
		}
		if (color == "Pink" || color == "Pi") {
			WebElement dressClr = driver.findElement(By.id("layered_id_attribute_group_24"));
			dressClr.click();
		}

		return this;
	}

}
