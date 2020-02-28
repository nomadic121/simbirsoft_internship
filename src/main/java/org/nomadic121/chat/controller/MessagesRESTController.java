package org.nomadic121.chat.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MessagesRESTController {

    private final @NonNull MessageService messageService;

    @GetMapping("/messages")
    public List<MessageDto> getMessagesList() {
        return messageService.getAllMessages();
    }

}
