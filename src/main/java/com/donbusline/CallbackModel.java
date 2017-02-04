package com.donbusline;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.IOException;

        public class CallbackModel {
            private String name;
            private String tel;
            private String[] countriescodes = new String[2];

            public CallbackModel(String name, String tel) {
                this.name = name;
                this.tel = tel;
                countriescodes[0] = "UA";
                countriescodes[1]="RU";
            }

            public void notifyRecipient() {
                Application app =  Application.getInstance();
                TelegramService telegramService = app.getService("TELEGRAM");
                try {
                    telegramService.sendMessage(app.getRecipientChatId(), name +" "+ tel);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }

    public  boolean validePhoneNumber (String number) {
        boolean isValid = false;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        for(int i= 0; i<countriescodes.length; i++){
            try {
                Phonenumber.PhoneNumber NumberProto  = phoneUtil.parse(number, countriescodes[i]);
                if(isValid= phoneUtil.isValidNumber(NumberProto)){
                    return isValid;
                }
            }
            catch(NumberParseException e){

            }
        }
        return false;
    }
}
