package org.nomadic121.chat.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.nomadic121.chat.models.Message;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class MessageDto {

    private String text;

    public static MessageDto from(final Message message) {
        return new MessageDto(message.getText());
    }

    public static List<MessageDto> from(final List<Message> messages) {
        return messages.stream().map(MessageDto::from).collect(Collectors.toList());
    }

}
