package org.nomadic121.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    @Mapping(source = "author.userName", target = "author")
    @Mapping(source = "chat.title", target = "chat")
    MessageDto messageToMessageDto(Message message);

}