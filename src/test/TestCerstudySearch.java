package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by milleb on 5/9/2014.
 */
public class TestCerstudySearch {

    @Test
    public void TestSearch() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://cerstudy.com/Certification/Certification/Certifications");
        driver.findElement(By.name("name")).sendKeys("C#");
        driver.findElement(By.name("submit")).click();
        Assert.assertEquals(1,driver.findElements(By.className("Certification")).toArray().length);
    }

    @Test
    public void TestSearchZeroResult() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://cerstudy.com/Certification/Certification/Certifications");
        driver.findElement(By.name("name")).sendKeys("fdsfsfsf");
        driver.findElement(By.name("submit")).click();
        Assert.assertEquals(0,driver.findElements(By.className("Certification")).toArray().length);
    }
}
