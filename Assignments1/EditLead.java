package week5.day1.Assignments1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditLead extends BaseClass
{
	@Test
	public void editLrad() throws Exception
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
