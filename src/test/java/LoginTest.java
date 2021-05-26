import manager.DataProviders;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        app.user().fillLoginForm(new User().withEmail("marsh@gmail.com").withPassword(""));
        logger.info("loggin with: "+"marsh@gmail.com "+ "Marsh1234$");
        //Marsh1234$
        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();

        Assert.assertTrue(app.user().isLoggend());
        logger.info("Test passed");
    }

    @DataProvider
    public Iterator <Object[]> dataFile() throws IOException {
        List <Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/data.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }


    @Test(dataProvider = "dataFile")
    public void loginTestFromFile(User user){

        app.user().openLoginForm();
        app.user().fillLoginForm(user);

        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();

        Assert.assertTrue(app.user().isLoggend());
        logger.info("Test passed");
    }

    @DataProvider
    public Iterator <Object[]> validData(){
        List <Object[]> list = new ArrayList<>();
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        list.add(new Object[]{"marsh@gmail.com","Marsh1234$"});
        return list.iterator();
    }

    @Test(dataProvider = "validData")
    public void loginTestDataProvider(String email, String password){
        app.user().openLoginForm();
        app.user().fillLoginForm(new User().withEmail(email).withPassword(password));

        //logger.info("loggin with: "+"marsh@gmail.com "+ "Marsh1234$");
        //Marsh1234$
        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();

        Assert.assertTrue(app.user().isLoggend());
        logger.info("Test passed");
    }

    @Test(dataProvider = "dataFile", dataProviderClass = DataProviders.class)
    public void loginTestFromFileFromClass(User user){

        app.user().openLoginForm();
        app.user().fillLoginForm(user);

        app.user().clickLoginButton();
        app.user().pause(2000);
        app.user().successLogin();

        Assert.assertTrue(app.user().isLoggend());
        logger.info("Test passed");
    }

//    @AfterMethod
//    public void postConditions(){
//        app.user().logout();
//    }
}
