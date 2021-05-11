import models.Car;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewCarTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.user().isLogin()){
            app.user().isLoginMethod();
        }

    }


    @Test
    public void  createNewCar(){
        app.car().openCarCreationForm();
        app.car().fillCarForm(new Car()
                .withLocation("Tel-Aviv")
                .withMake("Subaru")
                .withModel("Forester")
                .withYear("2020")
                .withEngine("2000")
                .withFuel("Petrol")
                .withGear("AT")
                .withWd("RWD")
                .withDoors("5")
                .withSeats("5")
                .withCarClass("Luxury")
                .withFuelConsumption("10")
                .withCarRegistrationNumber("7667517")
                .withPrice("400")
                .withDistanceIncluded("450")
                .withFeatures("Music")
                .withAbout("Good car")
        );
        //logger.info("");
        app.car().clickAddFeatureButton();

        app.car().attachPhotos("/Users/annapogrebinskaya/Documents/GitHub/IICarro_v.0.1_Qa27/model-3-saloon-TEM3.jpg");
        app.car().pause(2000);
        app.car().clickSubmitButton();
        app.car().pause(2000);

        Assert.assertTrue(app.car().isCarAdded());
       // logger.info("test passed");


    }

    @AfterMethod
    public void postConditions(){
       // app.user().logout();

    }
}
