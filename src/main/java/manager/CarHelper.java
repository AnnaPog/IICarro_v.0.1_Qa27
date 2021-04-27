package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarCreationForm() {
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void fillNewCarForm(Car car) {
        type(By.xpath("//input[@id='pickUpPlace']"), car.getLocation());
        type(By.xpath("//input[@id='make']"), car.getMake());
        type(By.xpath("//input[@id='model']"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        click(By.id("fuel"));
        click(By.id("gear"));
        click(By.id("wheelsDrive"));
        type(By.cssSelector("#doors"), car.getDoors());
        type(By.cssSelector("#seats"), car.getSeats());
        type(By.cssSelector("#class"), car.getCarClass());
        type(By.id("fuelConsumption"), car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegistrationNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"), car.getDistanceIncluded());
        type(By.xpath("//input[@placeholder='Type feature']"), car.getFeatures());
        type(By.id("about"), car.getAbout());

    }

    public void addPhotos() {
        WebElement el = wd.findElement(By.xpath("//label[.='Add photos of your car']"));
        el.click();
        el.sendKeys("model-3-saloon-TEM3.jpg");
    }

    public void clickAddFeatureButton() {
        click(By.xpath("//button[.='Add feature']"));
    }

    public void clickSubmitButton() {
        click(By.xpath("//button[.='Submit']"));
    }
}
