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
