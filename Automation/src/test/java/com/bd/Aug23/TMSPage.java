package com.bd.Aug23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TMSPage extends BrowserSetup {
	static String baseUrl ="https://tms-test.celloscope.net/login";
	@Test
	public void login() throws InterruptedException{
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement UserID = driver.findElement(By.xpath("//input[@type='text']"));
		UserID.sendKeys("titu.admin");
		Thread.sleep(2000);
		WebElement Pass = driver.findElement(By.xpath("//input[@type='password']"));
		Pass.sendKeys("sa");
		Thread.sleep(2000);
		WebElement  loginButton= driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
		loginButton.click();
		Thread.sleep(5000);
		//driver.switchTo().newWindow(null)
		//WebElement Menu = driver.findElement(By.xpath("//mat-icon[contains(text(),'menu')]"));
		//Menu.click();
		WebElement project = driver.findElement(By.cssSelector("#mat-expansion-panel-header-2"));
		project.click();
		Thread.sleep(2000);

		WebElement Projectlist = driver.findElement(By.xpath("//span[contains(text(),' Project List ')]"));
		Projectlist.click();
		Thread.sleep(2000);

		
		WebElement CssAddproject = driver.findElement(By.cssSelector("#cdk-accordion-child-2"));
		CssAddproject.click();
		Thread.sleep(2000);
		//WebElement Cssproject = driver.findElement(By.xpath("//body/app-root[1]/app-main-shell[1]/app-sidebar[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/app-side-navbar[1]/mat-nav-list[1]/mat-expansion-panel[3]/div[1]/div[1]/mat-nav-list[1]/mat-list-item[2]/span[1]/span[1]"));
		//Cssproject.click();
		
		WebElement BanglaTitle = driver.findElement(By.xpath("//app-input[@formcontrolname='projectTitleBn']"));
		BanglaTitle.click();
		WebElement BanglaTitleInput = driver.findElement(By.xpath("//input[@placeholder='Enter Project Title in Bengali']"));
		BanglaTitleInput.sendKeys("Sakif");
		Thread.sleep(2000);
		WebElement EnglishTitleInput = driver.findElement(By.xpath("//input[@placeholder='Enter Project Title in English']"));
		EnglishTitleInput.sendKeys("Sakif");
		Thread.sleep(2000);
		WebElement DescriptionInput = driver.findElement(By.xpath("//textarea[@placeholder='Enter a description here']"));
		DescriptionInput.sendKeys("My name is Sakif");
		Thread.sleep(2000);
		WebElement SubmitButton = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
		SubmitButton.click();
		Thread.sleep(2000);
		WebElement CheckListButton = driver.findElement(By.xpath("//span[contains(text(),'Check List')]"));
		CheckListButton.click();
		Thread.sleep(2000);

		
		
	}

}
