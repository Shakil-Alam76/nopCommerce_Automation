import Pages.Place_Order;
import Pages.Registration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestRunner extends Setup {
    Place_Order objPlaceOrder;
    Registration objRegistration;
    Registration objemailGenerate;


    @Test(priority = 1, description = "User Registration", enabled = true)
    public void do_Registration () throws IOException, ParseException {
    driver.get("https://training.nop-station.com");
    objRegistration=new Registration(driver);

        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader("./src/test/resources/User.json"));
        JSONObject jsonObject = (JSONObject) obj;
        String fName=(String) jsonObject.get("First_Name");
        String lname=(String) jsonObject.get("Last_Name");
        String mail=(String) jsonObject.get("Email");
        String companyName=(String) jsonObject.get("Company_Name");
        String pass=(String) jsonObject.get("password");
        String confirmPass=(String) jsonObject.get("Confirm_password");

        String user=objRegistration.do_registration(fName,lname, mail, companyName, pass, confirmPass);

    }


  @Test(priority = 2, description = "Place Order", enabled = true)
    public void orderPlace() throws IOException, ParseException {
      driver.get("https://training.nop-station.com");
      objPlaceOrder=new Place_Order(driver);
      JSONParser jsonParser=new JSONParser();
      Object obj=jsonParser.parse(new FileReader("./src/test/resources/Billing_info.json"));
      JSONObject jsonObject = (JSONObject) obj;
      String f_Name=(String) jsonObject.get("First_Name");
      String l_Name=(String) jsonObject.get("Last_Name");
      String email=(String) jsonObject.get("Email");
      String company=(String) jsonObject.get("Company_Name");
      String city=(String) jsonObject.get("City");
      String address_1=(String) jsonObject.get("Address_1");
      String zip_code=(String) jsonObject.get("Zip");
      String phone=(String) jsonObject.get("Phone");
      String cardHolderName=(String) jsonObject.get("Card_Holder_Name");
      String cardNumber=(String) jsonObject.get("Card_Number");
      String card_cvv=(String) jsonObject.get("Card_CVV_Number");

      String billingInfo= objPlaceOrder.place_order(f_Name,l_Name,email,company,city,address_1,zip_code,phone,cardHolderName,cardNumber,card_cvv);

  }

}
