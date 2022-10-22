package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Registration {
    WebDriver driver;
    @FindBy(className = "ico-register")
    WebElement linkSignup;
    @FindBy(id = "gender-male")
    WebElement select_gender;
    @FindBy(id = "FirstName")
    WebElement first_Name;
    @FindBy(id ="LastName")
    WebElement lastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement dob_Day;
    @FindBy(name = "DateOfBirthMonth")
    WebElement dob_month;
    @FindBy(name = "DateOfBirthYear")
    WebElement dob_Year;
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Company")
    WebElement company_Name;
    @FindBy(id = "Newsletter")
    WebElement newsletter_Check;
    @FindBy(id = "Password")
    WebElement password;
    @FindBy(id = "ConfirmPassword")
    WebElement confirm_pass;
    @FindBy(id = "register-button")
    WebElement reg_button;
    @FindBy(xpath = "//div[contains(text(),'Your registration completed')]")
    WebElement reg_sucessfull_msg;
    @FindBy(className = "ico-logout")
    WebElement logout;


    public Registration(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    public String do_registration(String fName, String lName, String mail, String companyName, String pass, String confirmPass ){
        linkSignup.click();
        select_gender.click();
        first_Name.sendKeys(fName);
        lastName.sendKeys(lName);
        Select date =new Select(dob_Day);
        date.selectByVisibleText("4");
        Select month =new Select(dob_month);
        month.selectByVisibleText("March");
        Select year =new Select(dob_Year);
        year.selectByVisibleText("1997");
        email.sendKeys(mail);
        company_Name.sendKeys(companyName);
        newsletter_Check.click();
        password.sendKeys(pass);
        confirm_pass.sendKeys(confirmPass);
        reg_button.submit();
        String registration_successfull=reg_sucessfull_msg.getText();
        Assert.assertEquals(registration_successfull, "Your registration completed");
        logout.click();

       return "Signup Sucessfull";
    }


}
