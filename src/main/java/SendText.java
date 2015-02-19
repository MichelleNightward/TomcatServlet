/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lrooo
 */
import java.util.HashMap;
import java.util.Map;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;

public class SendText {
            /* Twilio REST API version */
    public static final String ACCOUNTSID = "sid";
    public static final String AUTHTOKEN = "token";
    
    public static void DoSmsStuff(){
    	
        /* Instantiate a new Twilio Rest Client */
        TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);

        // Get the account and call factory class
        Account acct = client.getAccount();
        SmsFactory smsFactory = acct.getSmsFactory();

        //build map of server admins
//        Map<String,String> admins = new HashMap<String,String>();
//        admins.put("4158675309", "Johnny");
//        admins.put("4158675310", "Helen");
//        admins.put("4158675311", "Virgil");
       
        String fromNumber = "number";

    	// Iterate over all our server admins
        //for (String toNumber : admins.keySet()) {
            
            //build map of post parameters 
            Map<String,String> params = new HashMap<String,String>();
            params.put("From", fromNumber);
            params.put("To", MainServlet.phoneNumber);
            params.put("Body", FortuneList.textFortune);

            try {
                // send an sms a call  
                // ( This makes a POST request to the SMS/Messages resource)
                Sms sms = smsFactory.create(params);
                System.out.println("Success sending SMS: " + sms.getSid());
                MainServlet.resultMessage = "Success! Want to send another one?";
            }
            catch (TwilioRestException e) {
                e.printStackTrace();
                MainServlet.resultMessage = "Please try again with a valid phone number.";
            }
        //}
    }    
}

