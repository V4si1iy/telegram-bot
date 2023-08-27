package pro.sky.telegrambot.componens;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component

public class SendNotification {
    @Autowired
    NotificationRepository repository;
    @Autowired
    TelegramBot telegramBot;
    @Scheduled(timeUnit = TimeUnit.MINUTES, fixedRate = 1)
    public void notification()
    {
        LocalDateTime data = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        repository.findByData(data).forEach(value -> {
            telegramBot.execute(new SendMessage(value.getChatId() ,"Напоминание: " + value.getMessage()));
        });

    }

}
