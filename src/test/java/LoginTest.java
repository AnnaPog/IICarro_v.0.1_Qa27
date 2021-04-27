import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void precondition(){
        if(app.user().isLoggend()){
            app.user().logout();
        }
    }

    @Test
    public void loginTest(){
        app.user().openLoginForm();
        app.user().fillLoginForm(new User().withEmail("marsh@gmail.com").withPassword("Marsh1234$"));
        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();

        Assert.assertTrue(app.user().isLoggend());
    }

    @AfterMethod
    public void postConditions(){
        app.user().logout();
    }
}
