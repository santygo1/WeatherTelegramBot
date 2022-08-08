import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiException exp){
            exp.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "santygobot";
    }

    @Override
    public String getBotToken() {
        return "5524174383:AAFppMWnmJOjecQsKkMWWdm_ZWx8XlEbjOE";
    }

    public void sendMsg(Message message, String answer){
        //Preparing message
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        //Defines chat id for answer
        sendMessage.setChatId(message.getChatId().toString());
        //Defines message id for answer
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(answer);

        //Sending message
        try{
            execute(sendMessage);
        }catch (TelegramApiException exception){
            exception.printStackTrace();
        }
    }

    //This method gets messages
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()){
            switch (message.getText()){
                case "/help":
                    sendMsg(message,"Чем могу помочь?");
                    break;
                case "/settings":
                    sendMsg(message, "Что будем настраивать?");
                    break;
                default:
            }
        }
    }

}
