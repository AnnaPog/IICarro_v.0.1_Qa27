package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.User;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[.=' Log in ']"));
    }

    public void fillLoginForm(User user) {
        type(By.xpath("//input[@id='email']"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void clickLoginButton() {
        click(By.xpath("//button[text()='Y’alla!']"));
    }

    public void successLogin() {
        click(By.xpath("//button[.='Ok']"));
    }

    public boolean isLoggend(){
        return isElementPresent(By.xpath("//a[.=' Logout ']"));
    }

    public void logout() {
        click((By.xpath("//a[.=' Logout ']")));
    }
}
