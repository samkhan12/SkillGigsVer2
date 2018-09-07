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

public class SignIn {
	
	

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

	 
 FileInputStream file = new FileInputStream(new File("E:\\Testdata.xlsx")); 
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
 
 workbook.close();
 file.close();
       }
}


public String clickLogin() throws InterruptedException {
  
  Thread.sleep(1000);
  
  WebElement signin=driver.findElement(By.id("btnSubmit"));
  signin.click();
  return driver.getTitle();
 }
 
 public void loadWebPage(String url) {
 
  driver = new FirefoxDriver();
  driver.get(url);
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}
}