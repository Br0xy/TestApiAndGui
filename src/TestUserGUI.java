import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by milleb on 5/9/2014.
 */
public class TestUserGUI{

    @Test
    public void AddUser() {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://localhost:62019/");
        driver.findElement(By.name("name")).sendKeys("Franso");
        driver.findElement(By.name("age")).sendKeys("22");
        driver.findElement(By.name("button")).click();

        Assert.assertEquals("http://localhost:62019/",driver.getTitle());
    }

}
