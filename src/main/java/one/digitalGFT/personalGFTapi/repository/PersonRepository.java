package one.digitalGFT.personalGFTapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import one.digitalGFT.personalGFTapi.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
