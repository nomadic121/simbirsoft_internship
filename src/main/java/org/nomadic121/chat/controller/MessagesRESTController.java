package org.nomadic121.chat.controller;

import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesRESTController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public List<MessageDto> getMessagesList() {
        return messageService.getAllMessages();
    }

}
