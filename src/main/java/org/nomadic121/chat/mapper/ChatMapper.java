package org.nomadic121.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nomadic121.chat.dto.ChatDto;
import org.nomadic121.chat.entity.Chat;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    ChatMapper INSTANCE = Mappers.getMapper(ChatMapper.class);

    @Mapping(source = "creator.name", target = "creator")
    ChatDto chatToChatDto(Chat chat);

}
