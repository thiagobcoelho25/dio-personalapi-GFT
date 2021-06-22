package one.digitalGFT.personalGFTapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalGFT.personalGFTapi.dto.request.PersonDTO;
import one.digitalGFT.personalGFTapi.dto.response.MessageResponseDTO;
import one.digitalGFT.personalGFTapi.entity.Person;
import one.digitalGFT.personalGFTapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	private ModelMapper modelMapper;
	
	@Autowired
	public PersonService(PersonRepository personRepository, ModelMapper modelMapper) {
		this.personRepository = personRepository;
		this.modelMapper = modelMapper;
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO){
		Person personToSave = modelMapper.map(personDTO, Person.class);
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder().message("created person with ID: "+ savedPerson.getId()).build();
	}
	
	public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(p -> modelMapper.map(p,PersonDTO.class))
                .collect(Collectors.toList());
    }
	
}
