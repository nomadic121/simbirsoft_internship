package org.nomadic121.chat.form;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class MessageForm {

    private String from;

    private String message;

    private Map<String, String> destination;

}