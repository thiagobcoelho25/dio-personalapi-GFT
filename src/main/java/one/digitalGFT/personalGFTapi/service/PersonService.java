package one.digitalGFT.personalGFTapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalGFT.personalGFTapi.dto.response.MessageResponseDTO;
import one.digitalGFT.personalGFTapi.entity.Person;
import one.digitalGFT.personalGFTapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person){
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("created person with ID: "+ savedPerson.getId()).build();
	}
	
}
