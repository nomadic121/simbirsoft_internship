package org.nomadic121.chat.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.nomadic121.chat.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class UserDto {

    private String name;

    public static UserDto from(final User user) {
        return new UserDto(user.getName());
    }

    public static List<UserDto> from(final List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }

}
