package com.donbusline;

import java.util.Map;

public class Application {
    private static Application instance;
    private String botToken;
    private String recipientChatId;
    private TelegramService telegramService;

    private Application() {
    }
    public static Application getInstance(){
        Map<String, String> env = System.getenv();
        if (instance == null){
            instance = new Application();
            instance.botToken = env.get("BOT_TOKEN");
            instance.recipientChatId = env.get("CHAT_ID");
        }
        return instance;
    }


    public TelegramService getService(String serviceName){
        if(serviceName == "TELEGRAM"){
            if(telegramService == null){
                telegramService = new TelegramService(instance.botToken);
            }
            return telegramService;
        }
        return null;
    }

    public String getRecipientChatId() {
        return recipientChatId;
    }

}
