package com.tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.listeners.MyListener;
import com.relevantcodes.extentreports.LogStatus;
import Test.EmployerSignUp;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;


public class TestEmployerSignUp extends MyListener {

EmployerSignUp mlp;


 @BeforeTest
 public void beforeTest() {
 System.out.println("in before test");
 mlp = PageFactory.initElements(driver, EmployerSignUp.class);

 }
 @AfterTest
 public void afterTest() {
 System.out.println("in after test");
 mlp = null;
 }
 
 @Test
 public void Test() throws InterruptedException, IOException {
 System.out.println("in test method");

 mlp.element();
 String title = mlp.clickSignUp();
  
 AssertJUnit.assertEquals(title, "Hire Top Tech Talent | Custom Pipeline of Sourced Talent");
 test.log(LogStatus.INFO, "the test tours is passed");
 
 }
 }