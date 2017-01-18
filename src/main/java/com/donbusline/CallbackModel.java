package com.donbusline;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.io.IOException;

public class CallbackModel {
    private String name;
    private String tel;

    public CallbackModel(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public void notifyRecipient(){
        Application app =  Application.getInstance();
        TelegramService telegramService = app.getService("TELEGRAM");
        try {
            telegramService.sendMessage(app.getRecipientChatId(), name +" "+ tel);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
