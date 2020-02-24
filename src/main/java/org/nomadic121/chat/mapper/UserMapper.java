package org.nomadic121.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nomadic121.chat.dto.UserDto;
import org.nomadic121.chat.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToUserDto(User user);

}
