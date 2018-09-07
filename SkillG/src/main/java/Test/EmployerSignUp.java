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

public class EmployerSignUp {
	
	

WebDriver driver;

public void element() throws InterruptedException, IOException {

 driver = new FirefoxDriver();
 String url= "https://dev.skillgigs.com/";
 driver.get(url);
 
 driver.manage().window().maximize(); //maximize the browser window
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
     Thread.sleep(2000);
     driver.findElement(By.id("u646")).click(); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	 driver.findElement(By.xpath("/html/body/header/div/div[1]/div[2]/nav/div/div[2]/ul[2]/li[1]/a")).click(); //click on login button
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
     
	 
 FileInputStream file = new FileInputStream(new File("E:\\Employer.xlsx")); 
 XSSFWorkbook workbook = new XSSFWorkbook(file);

 XSSFSheet sheet = workbook.getSheetAt(0);

 for (int i=0; i <= sheet.getLastRowNum(); i++)
 
      {
	 
	 
         Thread.sleep(5000); //wait for loading screen
 
         WebElement fname = driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[1]/div/input[1]"));
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         WebElement lname = driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[2]/div/input")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         WebElement email = driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[3]/div/input")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         WebElement phone = driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[4]/div/input")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         WebElement company = driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[5]/div/input")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
       
         
         String fnamecell = sheet.getRow(i).getCell(0).getStringCellValue();
         String lnamecell = sheet.getRow(i).getCell(1).getStringCellValue();
         String emailcell = sheet.getRow(i).getCell(2).getStringCellValue();
         String phonecell = sheet.getRow(i).getCell(3).getStringCellValue();
         String companycell = sheet.getRow(i).getCell(4).getStringCellValue();

         fname.sendKeys(fnamecell);
         lname.sendKeys(lnamecell);
         email.sendKeys(emailcell);
         phone.sendKeys(phonecell);
         company.sendKeys(companycell);
       
            driver.findElement(By.xpath("//*[@id=\"contactform\"]/div[6]/div/button")).click(); //Click on Sign up button
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	
	    	
	    

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
