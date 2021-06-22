package one.digitalGFT.personalGFTapi.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalGFT.personalGFTapi.dto.response.MessageResponseDTO;
import one.digitalGFT.personalGFTapi.entity.Person;
import one.digitalGFT.personalGFTapi.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PersonResource {
	
	private PersonService personService;
	
	@Autowired
	public PersonResource(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody Person person){
		return personService.createPerson(person);
	}
	
}
