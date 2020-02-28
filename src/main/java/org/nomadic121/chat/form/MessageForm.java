package org.nomadic121.chat.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageForm {

    private String from;

    private String message;

}