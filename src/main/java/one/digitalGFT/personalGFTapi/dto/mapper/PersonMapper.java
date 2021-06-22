package one.digitalGFT.personalGFTapi.dto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import one.digitalGFT.personalGFTapi.dto.request.PersonDTO;
import one.digitalGFT.personalGFTapi.entity.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);
    
    PersonDTO toDTO(Person dto);
}