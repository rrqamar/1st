package com.project.jQueryUI;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JqueryUITest {
	private WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		//System.setProperty("", value)
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void jQueryUi()
	{
		//goto website
		driver.get("https://jqueryui.com/");
		/////////////////////////////////////////////////////////////////action class////////////////////
		/** //1.	Draggable 
		WebElement draggable = driver.findElement(By.linkText("Draggable"));
		draggable.click();
		customWait(2);
		toIFram();
		Actions actionDrag = new Actions(driver);
		WebElement drag = driver.findElement(By.id("draggable"));
		actionDrag.clickAndHold(drag).moveByOffset(10, 50).build().perform();
		customWait(3);
		switchToDefault();
		
		//2.	Droppable
		WebElement droppable=driver.findElement(By.linkText("Droppable"));
		droppable.click();
		customWait(2);
		toIFram();
		Actions actionDrop = new Actions(driver);
		WebElement drop =driver.findElement(By.id("draggable"));
		WebElement dropTarget=driver.findElement(By.id("droppable"));
		actionDrop.clickAndHold(drop).moveToElement(dropTarget).perform();
		customWait(3);
		switchToDefault();
		
		//3.	Resizable
		WebElement resizeable=driver.findElement(By.linkText("Resizable"));
		resizeable.click();
		customWait(2);
		toIFram();
		WebElement resize=driver.findElement(By.id("resizable"))
				.findElement(By.cssSelector(".ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
		Actions actionResize = new Actions(driver);
		actionResize.clickAndHold(resize).moveByOffset(20, 10).perform();
		customWait(3);
		switchToDefault();
		
		//4.	Selectable
		WebElement selectAble=driver.findElement(By.linkText("Selectable"));
		selectAble.click();
		customWait(2);
		toIFram();
		WebElement selectFrom=driver.findElement(By.cssSelector("li:nth-child(3)"));
		WebElement selectTo=driver.findElement(By.cssSelector("li:nth-child(5)"));
		Actions actionSelect= new Actions(driver);
		actionSelect.clickAndHold(selectFrom).clickAndHold(selectTo).perform();
		customWait(3);
		switchToDefault();
		
		/** //5.	Sortable(need assistance)
		WebElement sortable=driver.findElement(By.linkText("Sortable"));
		sortable.click();
		customWait(2);
		toIFram();
		WebElement sortFrom=driver.findElement(By.cssSelector("li:nth-child(2)"));
		WebElement sortTo=driver.findElement(By.cssSelector("li:nth-child(5)"));
		Actions actionSort= new Actions(driver);
		actionSort.dragAndDrop(sortFrom, sortTo).perform();
		customWait(10);**/
		
		
		//////////////////////////////////////////////////////////////////////////////////
		/** //1.	Accordion
		WebElement accordion = driver.findElement(By.linkText("Accordion"));
		accordion.click();
		customWait(2);
		toIFram();
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0, 450)", "");
		driver.findElement(By.id("ui-id-3")).click();
		customWait(3);
		switchToDefault();
		
		//2.	Autocomplete(done)
		WebElement autocomplete=driver.findElement(By.linkText("Autocomplete"));
		autocomplete.click();
		customWait(2);
		toIFram();
		WebElement autocompText=driver.findElement(By.id("tags"));
		autocompText.click();
		autocompText.clear();
		autocompText.sendKeys("as");
		customWait(2);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", 
				driver.findElement(By.cssSelector("li:nth-child(2)")));
		customWait(3);
		switchToDefault();**/
		
		//3.	Button(need assistance)
		WebElement btn=driver.findElement(By.linkText("Button"));
		btn.click();
		customWait(2);
		toIFram();
		WebElement btn1=driver.findElement(By.className("widget"))
				.findElement(By.tagName("button"));
		btn1.click();
		customWait(2);
		WebElement btn2=driver.findElement(By.xpath("html/body/a"));
		//highlightElement(btn2);
		btn2.click();
		customWait(2);
		switchToDefault();
		/**
		//4.	Checkboxradio(done)
		WebElement checkRadio=driver.findElement(By.linkText("Checkboxradio"));
		checkRadio.click();
		toIFram();
		customWait(2);
		WebElement locBtn=driver.findElement(By.cssSelector("label[for='radio-2']"));
		locBtn.click();
		customWait(1);
		WebElement ratingBtn=driver.findElement(By.cssSelector("label[for='checkbox-3']"));
		ratingBtn.click();
		JavascriptExecutor btnWin = (JavascriptExecutor)driver;
		btnWin.executeScript("window.scrollBy(0, 450)", "");
		customWait(1);
		WebElement bedBtn=driver.findElement(By.cssSelector("label[for='checkbox-nested-4']"));
		bedBtn.click();
		customWait(2);
		switchToDefault();
		
		//5.	Controlgroup(done)
		WebElement ctrlGrp=driver.findElement(By.linkText("Controlgroup"));
		ctrlGrp.click();
		customWait(1);
		toIFram();
		WebElement carTyp=driver.findElement(By.cssSelector("#car-type-button"));
		carTyp.click();
		customWait(1);
		//select car type
		WebElement selecMnu=driver.findElement(By.cssSelector("#car-type-menu"));
		WebElement selectCar=selecMnu.findElement(By.cssSelector("li:nth-child(4)"));
		selectCar.click();
		//select transmission type
		WebElement selectTrans=driver.findElement(By.cssSelector("label[for='transmission-automatic']"));
		selectTrans.click();
		//check for insurance
		WebElement selectIns=driver.findElement(By.cssSelector("label[for='insurance']"));
		selectIns.click();
		//select number of car needeed
		WebElement noOfCar=driver.findElement(By.cssSelector("#horizontal-spinner"));
		noOfCar.click();
		noOfCar.clear();
		noOfCar.sendKeys("3");
		//click book btn
		WebElement bookBtn=driver.findElement(By.
				cssSelector(".ui-widget.ui-controlgroup-item.ui-button.ui-corner-right"));
		bookBtn.click();
		customWait(2);
		switchToDefault();
		
		//6.	Datepicker(done)
		WebElement datePicker=driver.findElement(By.linkText("Datepicker"));
		datePicker.click();
		customWait(1);
		toIFram();
		WebElement pickDate=driver.findElement(By.id("datepicker"));
		pickDate.click();
		customWait(1);
		WebElement clkDate=driver.findElement(By.id("ui-datepicker-div"));
		clkDate.findElement(By.tagName("tbody")).findElement(By.cssSelector("tr:nth-child(2)"))
		.findElement(By.cssSelector("td:nth-child(3)"));
		clkDate.click();
		customWait(2);
		switchToDefault();**/
		
//		//7.	Dialog(need assistance)
//		WebElement dialog=driver.findElement(By.linkText("Dialog"));
//		dialog.click();
//		customWait(1);
//		toIFram();
//		//resize dialogBox
//		WebElement dialogResize=driver.findElement(By.cssSelector(".ui-resizable-handle.ui-resizable-se.ui-icon.ui-icon-gripsmall-diagonal-se"));
//		Actions actDialgResz= new Actions(driver);
//		actDialgResz.clickAndHold(dialogResize).moveByOffset(20, 20).perform();
//		actDialgResz.click(dialogResize).release();
//		
//		actDialgResz.release();
//		customWait(5);
//		//to close dialog box
//		WebElement closeBtn=driver.findElement(By.cssSelector(".ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close"));
//		closeBtn.click();
//		//WebElement closeBtn=driver.findElement(By.tagName("button"));
//		//closeBtn.click();
//		customWait(3);
//		WebElement closeBtn1=driver.findElement(By.cssSelector(".ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close"));
//		closeBtn1.click();
//		switchToDefault();
//		//.ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close
//		//.ui-button.ui-corner-all.ui-widget.ui-button-icon-only.ui-dialog-titlebar-close
		
		/** //8.	Menu(done)
		WebElement menu1=driver.findElement(By.linkText("Menu"));
		menu1.click();
		customWait(1);
		toIFram();
		WebElement mainMenu=driver.findElement(By.id("menu"));
		mainMenu.findElement(By.id("ui-id-9")).click();
		customWait(1);
		mainMenu.findElement(By.id("ui-id-10")).click();
		customWait(1);
		mainMenu.findElement(By.id("ui-id-11")).click();
		customWait(1);
		switchToDefault();**/

		/** //9.	Select menu(done)
		WebElement selectMenu=driver.findElement(By.linkText("Selectmenu"));
		selectMenu.click();
		customWait(1);
		toIFram();
		WebElement speed=driver.findElement(By.id("speed-button"));
		speed.click();
		customWait(1);
		WebElement speenM=driver.findElement(By.id("speed-menu"));
		speenM.findElement(By.cssSelector("li:nth-child(5)")).click();
		switchToDefault();
		customWait(2);
		
		//10.	Slider(done)
		WebElement slider=driver.findElement(By.linkText("Slider"));
		slider.click();
		customWait(2);
		toIFram();
		WebElement sliderBtn=driver.findElement
				(By.tagName("span"));
		Actions actionSlide=new Actions(driver);
		actionSlide.dragAndDropBy(sliderBtn, 50, 0).perform();
		customWait(2);
		switchToDefault();
		
		//11.	Tabs(done)
		WebElement tabs=driver.findElement(By.linkText("Tabs"));
		tabs.click();
		customWait(1);
		toIFram();
		WebElement tabsBtn=driver.findElement(By.cssSelector("#ui-id-2"));
		tabsBtn.click();
		customWait(1);
		switchToDefault();**/
		
		//12.	Tooltip
		WebElement toolTip=driver.findElement(By.linkText("Tooltip"));
		toolTip.click();
		customWait(1);
		toIFram();
		WebElement tooltip1=driver.findElement(By.xpath("html>body>p>a"));
		


	}
	
	@AfterMethod
	public void teardown() throws Exception {
	Thread.sleep(3*1000);
		driver.close();
		driver.quit();
		
	}
	
	public void highlightElement(WebElement element) {
		try {
			for (int i = 0; i < 4; i++) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
				Thread.sleep(500);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: red; border: 2px solid yellow;");
				Thread.sleep(500);
				js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
			}
		} catch (Exception e) {
			
		}
		}
	public void customWait(int n){
		try {
			Thread.sleep(n*1000);
		} catch (InterruptedException e) {
					e.printStackTrace();
		}
		
	}

	private void toIFram() {
		WebElement sxs= driver.findElement(By.cssSelector("iframe.demo-frame"));
		//highlightElement(sxs);
		//WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(sxs);
		
	}
	private void switchToDefault() {
		
			driver.switchTo().defaultContent();
		} 
	

}
