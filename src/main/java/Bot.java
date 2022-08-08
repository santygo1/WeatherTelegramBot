import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
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

    //This method gets messages
    @Override
    public void onUpdateReceived(Update update) {

    }
}
