package week5.day1.Assignments2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Attributes extends BaseClass
{
	@Test(priority=1,invocationCount = 2,threadPoolSize=1) //threadpoolsize=2
	public void createLead() 
	{
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("02/11/98");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7708921844");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("*1108");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("thiru110298@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("no 1,pillaiyar koil st,keelkattalai");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("no 1,pillaiyar koil st,keelkattalai");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		WebElement country=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countryName=new Select(country);
		countryName.selectByVisibleText("India");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600117");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("044");
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateName=new Select(state);
		stateName.selectByVisibleText("TAMILNADU");
		driver.findElement(By.className("smallSubmit")).click();
	}
	
	@Test(priority=3,dependsOnMethods="createLead",enabled=false)
	public void deleteLead() throws Exception 
	{
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		driver.findElement(By.partialLinkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("7708921844");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadId=driver.findElement(By.xpath("(//a[contains(@class,'linktext')])[4]")).getText();
		driver.findElement(By.xpath("(//a[contains(@class,'linktext')])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Delete")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String deleted_Record=driver.findElement(By.className("x-paging-info")).getText();
		if(deleted_Record.equalsIgnoreCase("No records to display"))
		{
			System.out.println("Deleted Succesfully");
		}
		else
		{
			System.out.println("Records not Deleted");
		}
	}
	
	@Test(dependsOnMethods="editLead")
	public void duplicateLead() throws Exception
	{
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("thiru110298@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		String name1=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		driver.findElement(By.partialLinkText("Duplicate Lead")).click();
		Thread.sleep(1000);
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String name2=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Thread.sleep(1000);
		if (name1.equalsIgnoreCase(name2)) 
		{
			System.out.println("The Duplicate name is "+name1);
		}
		else
		{
			System.out.println("No Duplicate Name");
		}
	}
	
	@Test(priority=2,dependsOnMethods="createLead")
	public void editLead() throws Exception
	{
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Thirumurugan");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf Always Ahead........");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
	}
}
