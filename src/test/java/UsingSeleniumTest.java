import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsingSeleniumTest {

    @Test
    public void qaTest() {
        WebDriver driver = new FirefoxDriver();
        String path = this.getClass().getResource("/qa-test.html").getPath();
        driver.get("file://" + path);

        String title = driver.getTitle();
        Assert.assertEquals(title, "Тест");

        WebElement loginInput = driver.findElement(By.id("loginEmail"));
        loginInput.sendKeys("test@protei.ru");

        WebElement passwordInput = driver.findElement(By.id("loginPassword"));
        passwordInput.sendKeys("test");

        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();

        WebElement data1 = driver.findElement(By.id("dataEmail"));
        data1.sendKeys("test@protei.ru");

        WebElement data2 = driver.findElement(By.id("dataName"));
        data2.sendKeys("Protei");

        WebElement selectGender = driver.findElement(By.id("dataGender"));
        Select select = new Select(selectGender);
        select.selectByVisibleText("Женский");

        driver.findElement(By.id("dataCheck11")).click();
        driver.findElement(By.id("dataCheck12")).click();
        driver.findElement(By.id("dataSelect21")).click();
        driver.findElement(By.id("dataSelect22")).click();
        driver.findElement(By.id("dataSelect23")).click();
        driver.findElement(By.id("dataSend")).click();

        WebElement message = driver.findElement(By.className("uk-modal-content"));
        String value2 = message.getText();
        Assert.assertEquals(value2, "Данные добавлены.");

        WebElement tableHead = driver.findElement(By.cssSelector("thead"));
        String value3 = tableHead.getText();
        Assert.assertEquals(value3, "E-Mail Имя Пол Выбор 1 Выбор 2");
        WebElement tableBody = driver.findElement(By.cssSelector("tbody"));
        String value4 = tableBody.getText();
        Assert.assertEquals(value4, "test@protei.ru Protei Женский 1.1, 1.2 2.3");

        driver.quit();
    }


}