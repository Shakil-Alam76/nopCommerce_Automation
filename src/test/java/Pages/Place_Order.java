package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Place_Order {

    WebDriver driver;
    //@FindBy(className = "sublist-toggle")
    @FindBy(xpath = "//body/div[6]/div[2]/ul[1]/li[6]/a[1]")
    WebElement cetagory_selection;
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/h2[1]/a[1]")
    WebElement select_cellPhone;
    @FindBy(linkText = "Nokia Lumia 1020")
    WebElement select_item;
    @FindBy(id = "product_enteredQuantity_20")
    WebElement input_qty;
    @FindBy(id = "add-to-cart-button-20")
    WebElement cart_add;
    @FindBy(className = "cart-label")
    WebElement view_cart;
    @FindBy(id = "termsofservice")
    WebElement tnS_check;
    @FindBy(id = "checkout")
    WebElement checkOut;
    @FindBy(xpath = "//button[contains(text(),'Checkout as Guest')]")
    WebElement checkout_as_guest;
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement billing_fName;
    @FindBy(id = "BillingNewAddress_LastName")
    WebElement billing_lName;
    @FindBy(id = "BillingNewAddress_Email")
    WebElement billing_email;
    @FindBy(id = "BillingNewAddress_Company")
    WebElement billing_company_Name;
    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement billing_country;
    @FindBy(id = "BillingNewAddress_StateProvinceId")
    WebElement billing_state;
    @FindBy(id = "BillingNewAddress_City")
    WebElement billing_City;
    @FindBy(id = "BillingNewAddress_Address1")
    WebElement billing_Address1;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement billing_Zip;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billing_Phone;
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]")
    WebElement billing_info_Submit;
    @FindBy(id = "shippingoption_1")
    WebElement shipping_method;
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]")
    WebElement shipping_submit;
    @FindBy(id = "paymentmethod_1")
    WebElement select_Card;
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]")
    WebElement card_Submit;
    @FindBy(id = "CreditCardType")
    WebElement select_card_type;
    @FindBy(id = "CardholderName")
    WebElement CardHolder_Name;
    @FindBy(id = "CardNumber")
    WebElement Card_Number;
    @FindBy(id = "ExpireMonth")
    WebElement card_Ex_Month;
    @FindBy(id = "ExpireYear")
    WebElement card_Ex_Year;
    @FindBy(id = "CardCode")
    WebElement card_Cvv_Code;
    @FindBy(xpath = "//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/button[1]")
    WebElement card_info_Submit;
   @FindBy(xpath = "//button[contains(text(),'Confirm')]")
   WebElement confirm_Order;
   @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
   WebElement order_Sucsessfull_msg;
   @FindBy(xpath = "//strong[contains(text(),'Your order has been successfully processed!')]")
   WebElement order_successfull_msg;

    public Place_Order(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String place_order(String f_Name,String l_Name, String email, String company,String city,String address_1, String zip_code,String phone, String cardHolderName, String cardNumber,String card_cvv){
        cetagory_selection.click();
        select_cellPhone.click();
        select_item.click();
        input_qty.clear();
        input_qty.sendKeys("2");
        cart_add.click();
        view_cart.click();
        tnS_check.click();
        checkOut.click();
        checkout_as_guest.click();
        billing_fName.sendKeys(f_Name);
        billing_lName.sendKeys(l_Name);
        billing_email.sendKeys(email);
        billing_company_Name.sendKeys(company);
        Select country= new Select(billing_country);
        country.selectByVisibleText("Bangladesh");
        Select state= new Select(billing_state);
        state.selectByValue("70");
        billing_City.sendKeys(city);
        billing_Address1.sendKeys(address_1);
        billing_Zip.sendKeys(zip_code);
        billing_Phone.sendKeys(phone);
        billing_info_Submit.click();
        shipping_method.click();
        shipping_submit.click();
        select_Card.click();
        card_Submit.click();
        Select cardType= new Select(select_card_type);
        cardType.selectByVisibleText("Visa");
        CardHolder_Name.sendKeys(cardHolderName);
        Card_Number.sendKeys(cardNumber);
        Select expierd_month= new Select(card_Ex_Month);
        expierd_month.selectByValue("6");
        Select expierd_year= new Select(card_Ex_Year);
        expierd_year.selectByVisibleText("2026");
        card_Cvv_Code.sendKeys(card_cvv);
        card_info_Submit.click();
        confirm_Order.click();
        String order_success_msg= order_successfull_msg.getText();
        Assert.assertEquals(order_success_msg, "Your order has been successfully processed!");

       return "Order Placed";
    }


}
