package Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {
	
	

WebDriver driver;

public void element() throws InterruptedException, IOException {

 driver = new FirefoxDriver();
 String url= "https://dev.skillgigs.com/";
 driver.get(url);
 driver.manage().window().maximize(); //maximize the browser window
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"u665\"]")).click(); 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	 driver.findElement(By.xpath("/html/body/header/div/div[1]/div[2]/nav/div/div[2]/ul[2]/li[2]/a")).click(); //click on login button
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	 
 FileInputStream file = new FileInputStream(new File("E:\\SignUp.xlsx")); 
 XSSFWorkbook workbook = new XSSFWorkbook(file);

 XSSFSheet sheet = workbook.getSheetAt(0);

 for (int i=0; i <= sheet.getLastRowNum(); i++)
 
      {
	 
	 
         Thread.sleep(5000); //wait for loading screen
 
         WebElement fname = driver.findElement(By.id("fullname"));
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

         WebElement email = driver.findElement(By.name("email")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         WebElement pwd = driver.findElement(By.name("pwd")); 
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         String fnamecell = sheet.getRow(i).getCell(0).getStringCellValue();
         String emailcell = sheet.getRow(i).getCell(1).getStringCellValue();
         String pwdcell = sheet.getRow(i).getCell(2).getStringCellValue();
         String phonecell = sheet.getRow(i).getCell(3).getStringCellValue();

         fname.sendKeys(fnamecell);
         email.sendKeys(emailcell);
         pwd.sendKeys(pwdcell);
       
         fname.submit();   
         email.submit();
         pwd.submit();

         System.out.println(fnamecell);
         System.out.println(emailcell);
         System.out.println(pwdcell);
         
            driver.findElement(By.id("btnSubmit")).click(); //Click on Sign up button
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	
	    	
	    	//driver.findElement(By.id("txtPreferredName")).clear();
           //driver.findElement(By.id("txtPreferredName")).sendKeys("Pradip");;
	    	
           // driver.navigate().refresh();
	        WebElement phone = driver.findElement(By.id("txtMobilePhone"));
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	phone.sendKeys(phonecell);
	    	phone.submit();

	    	Thread.sleep(1000);
            Select profession = new Select(driver.findElement(By.id("ddlProfessions")));
			profession.selectByIndex(1);
			
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ddlVisaStatuses")));
		    element.click();         
			
			Thread.sleep(1000);
            Select citizenship = new Select(driver.findElement(By.id("ddlVisaStatuses")));
			citizenship.selectByIndex(2);

		
	    	Thread.sleep(3000);
	
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/form/div[3]/button")).click();
	        System.out.println("Yes");
	        
	        

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
