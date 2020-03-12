package org.nomadic121.chat.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserForm {

    private String name;

    private String hashPass;

    private String role;

}
