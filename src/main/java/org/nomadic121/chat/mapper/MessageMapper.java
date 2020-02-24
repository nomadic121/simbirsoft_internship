package org.nomadic121.chat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.nomadic121.chat.dto.MessageDto;
import org.nomadic121.chat.entity.Message;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    MessageMapper INSTANCE = Mappers.getMapper(MessageMapper.class);

    MessageDto messageToMessageDto(Message message);

}