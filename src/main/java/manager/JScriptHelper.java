package manager;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JScriptHelper extends HelperBase{
    public JScriptHelper(WebDriver wd) {
        super(wd);
    }

    //[argument^=''] [argument*=''] [argument$='']
    JavascriptExecutor js = (JavascriptExecutor) wd;

    public void typeTextInTextBox(){
        // js.executeScript("document.getElementById('some id').value='someValue';");
        js.executeScript("document.getElementById('city').value='Haifa';");
    }

    public void clickOnButton(){
        //js.executeScript("document.getElementById('enter your element id').click();");
        js.executeScript("document.getElementById('0').click();");
        js.executeScript("document.querySelector('.header a:last-child').click();");
        js.executeScript("document.querySelector('a[href*=registration]').click();");

    }

    public void checkBox(){
        //js.executeScript("document.getElementById('enter element id').checked=false;");
        js.executeScript("document.getElementById('terms-of-use').checked=true;");
    }

    public void novigateTo(){
        //js.executeScript("window.location = 'https://www.softwaretestingmaterial.com");
        js.executeScript("window.location = 'https://www.google.com'");

    }

    public void scrollPage(){
        js.executeScript("window.scrollBy(0,300);");
        js.executeScript("window.scrollBy(0,-300);");

    }

    public void alertMy(){
        js.executeScript("alert('WELCOME');");


    }

    public void url(){
        String sText =  js.executeScript("return document.URL;").toString();
    }

    public void refresh(){
        js.executeScript("history.go(0)");
    }
}
