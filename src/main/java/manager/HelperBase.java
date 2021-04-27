package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text != null){
          WebElement el = wd.findElement(locator);
          el.click();
          el.clear();
          el.sendKeys(text);
        }
    }

    public void pause(int milles){
        try {
            Thread.sleep(milles);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public boolean isLogin(){
        return isElementPresent(By.xpath("//a[.=' Log in ']"));

    }

    public void isLoginMethod() {
        click(By.xpath("//a[.=' Log in ']"));
        type(By.xpath("//input[@id='email']"), "marsh@gmail.com");
        type(By.id("password"), "Marsh1234$");
        click(By.xpath("//button[text()='Y’alla!']"));
        pause(1000);
        click(By.xpath("//button[.='Ok']"));
    }

}
