import models.Car;
import models.User;
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
        app.car().fillNewCarForm(new Car()
                .withLocation("")
                .withMake("")
                .withModel("")
                .withYear("")
                .withEngine("")
                //.withFuel()
               // .withGear()
                //.withWd()
                .withDoors("")
                .withSeats("")
                .withFuelConsumption("")
                .withCarRegistrationNumber("")
                .withPrice("")
                .withDistanceIncluded("")
                .withFeatures("")
                .withAbout("")
        );
        app.car().clickAddFeatureButton();
        app.car().addPhotos();
        app.car().clickSubmitButton();


    }

    @AfterMethod
    public void postConditions(){
        app.user().logout();

    }
}
