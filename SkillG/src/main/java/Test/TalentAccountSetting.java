package Test;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TalentAccountSetting {
	
	

WebDriver driver;

public void element() throws InterruptedException, IOException {

 driver = new FirefoxDriver();
 String url= "https://dev.skillgigs.com/";
 driver.get(url);
 driver.manage().window().maximize(); //maximize the browser window
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
     Thread.sleep(3000);
     driver.findElement(By.xpath("//*[@id=\"u665\"]")).click(); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	 driver.findElement(By.xpath("/html/body/header/div/div[1]/div[2]/nav/div/div[2]/ul[2]/li[1]/a")).click(); //click on login button
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	 
 FileInputStream file = new FileInputStream(new File("E:\\Talent.xlsx")); 
 XSSFWorkbook workbook = new XSSFWorkbook(file);

 XSSFSheet sheet = workbook.getSheetAt(0);

 for (int i=0; i <= sheet.getLastRowNum(); i++)
 
      {
	 
	 
 Thread.sleep(5000); //wait for loading screen
 
 WebElement user = driver.findElement(By.name("email"));
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 WebElement pass = driver.findElement(By.name("pwd")); 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 String usercell = sheet.getRow(i).getCell(0).getStringCellValue();
 String passcell = sheet.getRow(i).getCell(1).getStringCellValue();
 user.sendKeys(usercell);
 pass.sendKeys(passcell);
 user.submit();   
 pass.submit();
 System.out.println(usercell);
 System.out.println(passcell);
 
 
 driver.findElement(By.id("btnSubmit")).click(); 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 Thread.sleep(5000);
 driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/span")).click();
 driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/a[1]")).click();
 
 driver.findElement(By.id("firstName")).clear();
 driver.findElement(By.id("firstName")).sendKeys("Sam");

 driver.findElement(By.id("lastName")).clear();
 driver.findElement(By.id("lastName")).sendKeys("jacob");
 
 driver.findElement(By.id("displayName")).clear();
 driver.findElement(By.id("displayName")).sendKeys("Samuel kha");
 
 driver.findElement(By.id("jobTitle")).clear();
 driver.findElement(By.id("jobTitle")).sendKeys("QA");
 
 driver.findElement(By.id("phoneNumber")).clear();
 driver.findElement(By.id("phoneNumber")).sendKeys("7894561234");
 
 driver.findElement(By.id("address1")).clear();
 driver.findElement(By.id("address1")).sendKeys("Sector31");
 
 driver.findElement(By.id("address2")).clear();
 driver.findElement(By.id("address2")).sendKeys("Noida");
 
 driver.findElement(By.id("location")).clear();
 driver.findElement(By.id("location")).sendKeys("Houston, TX");
 
 driver.findElement(By.id("zipCode")).clear();
 driver.findElement(By.id("zipCode")).sendKeys("77001");
 
driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[6]/div/div/div/div[1]/button"));
driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[6]/div/div/div/div[1]/div/ul/li[2]/a/span[1]"));

 
driver.findElement(By.id("btnSubmit")).click();
 
 
 workbook.close();
 file.close();
       
      
      }
}

public String clickSignUp() throws InterruptedException {
	  
return driver.getTitle();

}

 
 public void loadWebPage(String url) {
 
  driver = new FirefoxDriver();
  driver.get(url);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
}