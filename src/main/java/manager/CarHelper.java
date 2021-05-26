package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHelper extends HelperBase{
    public CarHelper(WebDriver wd) {
        super(wd);
    }

    public void openCarCreationForm() {
        click(By.xpath("//a[.=' Let the car work ']"));
    }

    public void fillCarForm(Car car) {
        type(By.xpath("//input[@id='pickUpPlace']"), car.getLocation());
        click(By.cssSelector("div.pac-item"));
        pause(2000);
        type(By.xpath("//input[@id='make']"), car.getMake());
        type(By.xpath("//input[@id='model']"), car.getModel());
        type(By.id("year"), car.getYear());
        type(By.id("engine"), car.getEngine());
        select(By.id("fuel"), car.getFuel());
        select(By.id("gear"), car.getGear());
        select(By.id("wheelsDrive"), car.getWd());
       // click(By.id("wheelsDrive"));
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

    public void attachPhotos(String link) {
//        WebElement el = wd.findElement(By.xpath("//label[.='Add photos of your car']"));
//        el.click();
//        el.sendKeys("model-3-saloon-TEM3.jpg");
        wd.findElement(By.id("photos")).sendKeys(link);
    }

    public void clickAddFeatureButton() {
        click(By.xpath("//button[.='Add feature']"));
    }

    public void clickSubmitButton() {
        click(By.xpath("//button[.='Submit']"));
    }

    public boolean isCarAdded() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        String text=wd.findElement(By.cssSelector("div.dialog-container h1")).getText();
        return text.contains("added");
    }

    public void findYourCar(Car car) {
        type(By.xpath("//input[@id='city']"), car.getLocation());
        click(By.cssSelector("div.pac-item"));
        typeDates(car.getDates());

    }


    public void typeDates(String dates) {
        WebElement days = wd.findElement(By.id("dates"));
        days.click();
        String os = System.getProperty("os.name");

        if(os.startsWith("Mac")){
            days.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }else {
            days.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }
        days.sendKeys(dates);
        days.sendKeys(Keys.ENTER);
    }

    public boolean findCar() {
        return isElementPresent(By.xpath("//h1[.=' Find your car now! ']"));
    }


    public void clickYallaButton() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void serchDays(String data1, String data2) {
        click(By.id("dates"));
        click(By.xpath(String.format("//div[.=' %s ']", data1)));
        click(By.xpath(String.format("//div[.=' %s ']", data2)));

    }

    public void findYourCity(Car car) {
        type(By.xpath("//input[@id='city']"), car.getLocation());
        click(By.cssSelector("div.pac-item"));
    }

    public boolean canNotPickDay() {
        return isElementPresent(By.xpath("//div[text()=\" You can't pick date before today \"]"));
    }

    public void searchAnotherCar(){
        wd.findElement(By.xpath("//button[text()='Search cars']")).click();
    }

    public void refresh() {
        wd.navigate().refresh();
    }
}
