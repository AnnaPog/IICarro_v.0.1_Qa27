package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {

    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public boolean listOfCarsAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormByType(String city, String dateFrom, String dataTo) {
        fillInputCity(city);
       // typeInputPeriod(dateFrom, dataTo);
        typeWithCntrV(dateFrom, dataTo);
    }

    private void typeInputPeriod(String dateFrom, String dataTo) {
        type(By.id("dates"), dateFrom + " - " + dataTo);
        wd.findElement(By.id("dates")).sendKeys(Keys.ENTER);
    }

    private void fillInputCity(String city) {
        type(By.xpath("//input[@id='city']"), city);
        click(By.cssSelector("div.pac-item"));


    }

    public void clickYallaBtn() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isListOfCarAppeared() {
        return isElementPresent(By.xpath("//div[@class='search-results']"));
    }

    public void fillSearchFormBySelectDate(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        selectPeriodCurrentMounth(dateFrom, dateTo);
    }

    private void selectPeriodCurrentMounth(String dateFrom, String dateTo) {
        wd.findElement(By.id("dates")).click();

        String[]from =dateFrom.split("/");
        String[]to = dateTo.split("/");
        //String locator ="//div[text()='"+from[1]+"']";

        String locator =String.format("//div[text()=' %s ']",from[1]);
        click(By.xpath(locator));
        String locator2 =String.format("//div[text()=' %s ']",to[1]);
        click(By.xpath(locator2));
    }

    public void fillSearchByTypeNeg(String city, String dateFrom, String dateTo) {
        fillInputCity(city);
        typeInputPeriodNeg(dateFrom, dateTo);
    }

    private void typeInputPeriodNeg(String dateFrom, String dateTo) {
        type(By.id("dates"), dateFrom + " - " + dateTo);
        wd.findElement(By.cssSelector(".cdk-overlay-container")).click();

    }

    public boolean buttonYallaInactive() {
        WebElement buttton = wd.findElement(By.xpath("//button[@type='submit']"));
        return !buttton.isEnabled();
    }

    public void fillSearchfrom(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodCheckDate(from, to);
    }

    private void typeInputPeriodCheckDate(String from, String to) {
        String[] dateFrom = from.split("/");
        String[] dateTo = to.split("/");
        click(By.id("dates"));
        int diffStart = 0;

        if (LocalDate.now().getMonthValue() != Integer.parseInt(dateFrom[0])) {
            diffStart = Integer.parseInt(dateFrom[0]) - LocalDate.now().getMonthValue();
        }

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator = String.format("//div[text()=' %s ']", dateFrom[1]);
        click(By.xpath(locator));

        int diff = 0;
        if(Integer.parseInt(dateTo[0])!=Integer.parseInt(dateFrom[0])){
            diff = Integer.parseInt(dateTo[0]) - Integer.parseInt(dateFrom[0]);
            for (int i = 0; i <diff ; i++) {
                click(By.xpath("//button[@aria-label='Next month']"));
            }
        }

        String locator2 = String.format("//div[text()=' %s ']", dateTo[1]);
        click(By.xpath(locator2));
    }

    public void fillNewSerchForm(String city, String from, String to) {
        fillInputCity(city);
        typeInputPeriodDate(from, to);
    }

    private void typeInputPeriodDate(String from, String to) {
        String[] dateFrom = from.split("/");
        String[] dateTo = to.split("/");
        click(By.id("dates"));

        //checkMonth(dateFrom[0]);
        int diffFrome = 0;
        if(LocalDate.now().getMonthValue() != Integer.parseInt(dateFrom[0])){
            diffFrome = Integer.parseInt(dateFrom[0]) - LocalDate.now().getMonthValue();
            System.out.println(diffFrome);
        }

        for (int i = 0; i<diffFrome; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator = String.format("//div[text()=' %s ']", dateFrom[1]);
        click(By.xpath(locator));

        //checkMonth(dateTo[0]);
        int diffTo = 0;

        if(LocalDate.now().getMonthValue() != Integer.parseInt(dateFrom[0])){
            diffTo = Integer.parseInt(dateTo[0]) - LocalDate.now().getMonthValue();
            System.out.println(diffTo);
        }

        int diffMonths = diffTo - diffFrome;
        System.out.println(diffMonths);
        for (int i = 0; i<diffMonths; i++){
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locator2 = String.format("//div[text()=' %s ']", dateTo[1]);
        click(By.xpath(locator2));
    }

    public void backToHomePage() {

//        click(By.xpath("//a[@href='/search']"));
//        clear(By.id("city"));
        wd.findElement(By.xpath("//a[@href='/']")).click();
        new WebDriverWait(wd,10)
                .until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//div[@class='search-container']"))));

    }

    private void clear(By locator) {
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
    }

//    private void checkMonth(String month) {
//        int diffMonth = 0;
//        if(LocalDate.now().getMonthValue() != Integer.parseInt(month)){
//            diffMonth = Integer.parseInt(month) - LocalDate.now().getMonthValue();
//        }
//
//        for (int i = 0; i<diffMonth; i++){
//            click(By.xpath("//button[@aria-label='Next month']"));
//        }
//
//    }

}
