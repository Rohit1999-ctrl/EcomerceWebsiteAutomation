package automationProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.Timer;

public class StandAloneTest {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/client");
        driver.findElement(By.id("userEmail")).sendKeys("rohitpbiju@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Rohit@123");
        driver.findElement(By.id("login")).click();

        List<WebElement> listofItems = driver.findElements(By.cssSelector(".mb-3"));
        for(WebElement list : listofItems){
            System.out.println(list.findElement(By.cssSelector("b")).getText());
            if(list.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")){
                list.findElement(By.cssSelector(".fa-shopping-cart")).click();
            }
            }
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

        //driver.close();
    }
}
