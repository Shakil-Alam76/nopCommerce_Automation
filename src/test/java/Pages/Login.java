package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
    @FindBy(className="login")
    WebElement linklogin;
    @FindBy(id = "email")
    WebElement textEmail;
    @FindBy(id = "passwd")
    WebElement textPassword;
    @FindBy(id ="SubmitLogin")
    WebElement buttonSubmitLogin;
    @FindBy(xpath = "//span[contains(text(),'Shakil Alam Shanto')]")
    WebElement userName;
    @FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
    WebElement authCheck;

    public Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String doLogin(String email, String password){
        linklogin.click();
        textEmail.sendKeys(email);
        textPassword.sendKeys(password);
        buttonSubmitLogin.click();
       return userName.getText();
    }

    //Login Authontication Test
    public String loginAuth(String email, String password){
        linklogin.click();
        textEmail.sendKeys(email);
        textPassword.sendKeys(password);
        buttonSubmitLogin.click();
        return authCheck.getText();
    }

}
