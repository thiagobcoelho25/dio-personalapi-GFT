package one.digitalGFT.personalGFTapi.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import one.digitalGFT.personalGFTapi.dto.request.PersonDTO;
import one.digitalGFT.personalGFTapi.dto.response.MessageResponseDTO;
import one.digitalGFT.personalGFTapi.exception.PersonNotFoundException;
import one.digitalGFT.personalGFTapi.service.PersonService;

@RestController
@RequestMapping("/api/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonResource {
	
	private PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
		return personService.createPerson(personDTO);
	}
	
	@GetMapping
	public List<PersonDTO> listAll() {
	    return personService.listAll();
	}
	 
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
	    return personService.findById(id);
	}
	 
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
	    return personService.update(id, personDTO);
	}
	 
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) throws PersonNotFoundException {
	     personService.delete(id);
	}
}
