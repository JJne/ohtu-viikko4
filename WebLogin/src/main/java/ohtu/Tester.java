package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
    

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/jannejau/Documents/yo/Kevät 2017/ohtu/chromedriver"); 

        WebDriver driver = new ChromeDriver();
        
        driver.get("http://localhost:4567");
        sleep(2);
        
        caseCorrectUsernameWrongPassword(driver);
        sleep(2);
        
        caseUsernameDoesNotExist(driver);
        sleep(2);
        
        driver.get("http://localhost:4567");
        sleep(2);
        
        caseRegisterNewUser(driver);
        sleep(2);
        
        caseLogoutAfterRegistration(driver);
        sleep(2);
         
        driver.quit();
    }
    
    private static void caseCorrectUsernameWrongPassword(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep_vaara");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
    }
    
    private static void caseUsernameDoesNotExist(WebDriver driver) {
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys("pekka_2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();
    }
    
    private static void caseRegisterNewUser(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka_2");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("signup"));
        
        sleep(2);
        element.submit();
    }
    
    private static void caseLogoutAfterRegistration(WebDriver driver) {
        WebElement element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
