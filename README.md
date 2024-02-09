
# Ticketing Management System Testing
Test site: https://tms-test.celloscope.net/dashboard

login info:  
UserID: titu.admin;  
Password: sa

The following instructions will help you navigate those testing pages.
Login to the web with the given credentials above. There is a menu, named Project, at the left side menu bar. Click on it. You will notice, there is a submenu named Project List. At the project list page, there is a list of projects where you can add, edit, search and view the projects.






## Target/Goals

Do the following tasks:
1. Write the user manual on 
a) How to add projects
b) How to edit projects

2. test cases on 
a) Add Project
b) Edit Project

3. Perform a manual test on the Add and Edit project. Track the issues
4. Perform automation test on the Add and Edit project. 

##  User Manual

User Manual PDF document: [user-manual.pdf](https://github.com/Sakif1997/WebAutomation/files/12113429/user-manual.pdf)

Document overview:
![T1](https://github.com/Sakif1997/WebAutomation/assets/45315685/d420c638-543b-498f-ac5e-00b6499690ca)
![T2](https://github.com/Sakif1997/WebAutomation/assets/45315685/46610b10-b119-4db2-abf2-d0a91b4db7a2)
![T3](https://github.com/Sakif1997/WebAutomation/assets/45315685/9a9e3f45-c420-4976-9a1c-0030cf4dd92f)

## Manual Part 

Given test Cases and testing procedure on 
a) Add Project b) Edit Project in this Xml file link:[TMS-Test-Cases (1) (2).xlsx](https://github.com/Sakif1997/WebAutomation/files/12113171/TMS-Test-Cases.1.2.xlsx)



### Issue list based on manual test on the Add and Edit project

Documented File: [Issues-list (1).docx.pdf](https://github.com/Sakif1997/WebAutomation/files/12113292/Issues-list.1.docx.pdf)


This Issue list contains Case ID(based on test case file), Issue Title, Issue Reproducing Steps, Actual result, expected result and issue image.
Issue list overview:

![i1](https://github.com/Sakif1997/WebAutomation/assets/45315685/320efd9f-15e6-494e-8d53-e59f0e5dfb63)
![i2](https://github.com/Sakif1997/WebAutomation/assets/45315685/d62a9022-e204-4559-b023-c29778ecf31c)
![i3](https://github.com/Sakif1997/WebAutomation/assets/45315685/e04b26f1-0c56-4f19-ba27-57f7f8abbfa6)
![e1](https://github.com/Sakif1997/WebAutomation/assets/45315685/2e933abd-9b47-4c76-9981-9ac8bcfd1d39)
![e2](https://github.com/Sakif1997/WebAutomation/assets/45315685/578a1445-2cff-4c53-8cc5-c88dda4286ae)
![e4](https://github.com/Sakif1997/WebAutomation/assets/45315685/db9594d3-da86-414b-9abe-4f64286f7067)


## Automation
The way my code works:
https://github.com/Sakif1997/TicketingManagementSystem_Manual-and-Automation-testing/assets/45315685/cbd8c8eb-a626-4d5e-96a6-49d5bedf388b


#### Driver Setup(pom.xml file)
```ruby
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.bd</groupId>
  <artifactId>6Aug23</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>6Aug23</name>
  <url>http://maven.apache.org</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  </properties>

  <dependencies>
      <!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.6.1</version>
    <scope>test</scope>
</dependency>
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.6.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.3.0</version>
</dependency>
  </dependencies>
</project>


```


#### Browser Setup file
```ruby
package com.bd.Aug23;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserSetup {
	WebDriver driver;
	@BeforeSuite
	public void start() {
		String browser = System.getProperty("browser", "chrome");
		if(browser.contains("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(option);
		}
		else if(browser.contains("Edge")) {
			EdgeOptions option = new EdgeOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(option);
		}
		else {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
		}
	}
	@AfterSuite
	public void end() {
		driver.quit();
	}

}

```

#### Add project and Checklist
```ruby
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
		
		//Home Page
		WebElement project = driver.findElement(By.cssSelector("#mat-expansion-panel-header-2"));
		project.click();
		Thread.sleep(2000);
		
		//Project checklist
		WebElement Projectlist = driver.findElement(By.xpath("//span[contains(text(),' Project List ')]"));
		Projectlist.click();
		Thread.sleep(2000);
		
		//Add project 
		WebElement CssAddproject = driver.findElement(By.cssSelector("#cdk-accordion-child-2"));
		CssAddproject.click();
		Thread.sleep(2000);
		
		//Add Project portal
		WebElement BanglaTitle = driver.findElement(By.xpath("//app-input[@formcontrolname='projectTitleBn']"));
		BanglaTitle.click();
		WebElement BanglaTitleInput = driver.findElement(By.xpath("//input[@placeholder='Enter Project Title in Bengali']"));
		WebElement EnglishTitleInput = driver.findElement(By.xpath("//input[@placeholder='Enter Project Title in English']"));
		WebElement DescriptionInput = driver.findElement(By.xpath("//textarea[@placeholder='Enter a description here']"));
		WebElement SubmitButton = driver.findElement(By.xpath("//span[contains(text(),'Submit')]"));
		BanglaTitleInput.sendKeys("Sakif");
		Thread.sleep(2000);
		EnglishTitleInput.sendKeys("Sakif");
		Thread.sleep(2000);
		DescriptionInput.sendKeys("My name is Sakif");
		Thread.sleep(2000);
		SubmitButton.click();
		Thread.sleep(2000);
		
		WebElement CheckListButton = driver.findElement(By.xpath("//span[contains(text(),'Check List')]"));
		CheckListButton.click();
		Thread.sleep(2000);	
	}

}

```



