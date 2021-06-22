package one.digitalGFT.personalGFTapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import one.digitalGFT.personalGFTapi.dto.mapper.PersonMapper;
import one.digitalGFT.personalGFTapi.dto.request.PersonDTO;
import one.digitalGFT.personalGFTapi.dto.response.MessageResponseDTO;
import one.digitalGFT.personalGFTapi.entity.Person;
import one.digitalGFT.personalGFTapi.exception.PersonNotFoundException;
import one.digitalGFT.personalGFTapi.repository.PersonRepository;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
	
	private final PersonRepository personRepository;
	
	private final PersonMapper personMapper;
	
	public MessageResponseDTO createPerson(PersonDTO personDTO){
		Person person = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder().message("Person successfully created with ID: "+ savedPerson.getId()).build();
	}
	
	public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }
	
	public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }
	
	public MessageResponseDTO update(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

        return messageResponse;
    }
	
	private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
