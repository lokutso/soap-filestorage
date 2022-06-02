package com.lokutson.producing;

import org.lokutson.producing_web_service.File;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FileMapper {

    FileMapper MAPPER = Mappers.getMapper(FileMapper.class);

    org.lokutson.producing_web_service.File toFileDto(com.lokutson.producing.File file);

    com.lokutson.producing.File toFileEntity(org.lokutson.producing_web_service.File file);
}
