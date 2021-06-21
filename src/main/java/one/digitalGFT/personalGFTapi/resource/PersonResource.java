package one.digitalGFT.personalGFTapi.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/people")
public class PersonResource {
	
	@GetMapping
	public String getBook() {
		return "API test";
	}
	
}
