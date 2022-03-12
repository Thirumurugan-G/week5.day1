package week5.day1.Assignments1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteLead extends BaseClass
{
	@Test
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
}
