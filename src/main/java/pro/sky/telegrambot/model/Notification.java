package pro.sky.telegrambot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data

public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long chatId;
    private String message;
    private LocalDateTime data;

    public Notification(Long chatId, String message, LocalDateTime data) {
        this.chatId = chatId;
        this.message = message;
        this.data = data;
    }
    public Notification()
    {

    }
}
