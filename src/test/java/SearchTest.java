import models.Car;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @Test
    public void typeSearchPeriod(){
        logger.info("Test type search period started");
       // app.car().fillCity("Haifa Israel");
        app.car().findYourCar(new Car()
        .withLocation("Haifa Israel")
        .withDates("5/17/21-5/20/21"));

       // app.car().typeDates("5/17/21-5/20/21");
        app.car().clickYallaButton();
        Assert.assertTrue(app.car().findCar());
        logger.info("Test passed");

        //5/10/2021 - 5/12/2021
    }

    @Test
    public void selectSerchPeriod(){
        logger.info("Test select serch petiod started");
        //5/10/2021 - 5/12/2021
        app.car().findYourCity(new Car()
                .withLocation("Haifa Israel"));
        app.car().serchDays("17", "27");
        app.car().clickYallaButton();
        Assert.assertTrue(app.car().findCar());
        logger.info("Test passed");
    }

    @Test
    public void negatTypePeriodInPath(){
        logger.info("Test negativ type period in path with invalid dates started");
        app.car().findYourCar(new Car()
                .withLocation("Haifa Israel")
                .withDates("5/05/21-5/20/21"));
        Assert.assertTrue(app.car().canNotPickDay());
        logger.info("Test passed");
        //4/10/2021 - 4/12/2021

    }
}
