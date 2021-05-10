import models.Car;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void typeSearchPeriod(){
       // app.car().fillCity("Haifa Israel");
        app.car().findYourCar(new Car()
        .withLocation("Haifa Israel")
        .withDates("5/17/21-5/20/21"));

       // app.car().typeDates("5/17/21-5/20/21");
        app.car().clickYallaButton();
        Assert.assertTrue(app.car().findCar());

        //5/10/2021 - 5/12/2021
    }

    @Test
    public void selectSerchPeriod(){
        //5/10/2021 - 5/12/2021
        app.car().findYourCar2(new Car()
                .withLocation("Haifa Israel"));
        app.car().serchDays("17", "27");
        app.car().clickYallaButton();
        Assert.assertTrue(app.car().findCar());
    }

    @Test
    public void negatTypePeriodInPath(){
        app.car().findYourCar(new Car()
                .withLocation("Haifa Israel")
                .withDates("5/05/21-5/20/21"));
        Assert.assertTrue(app.car().canNotPickDay());
        //4/10/2021 - 4/12/2021

    }
}
