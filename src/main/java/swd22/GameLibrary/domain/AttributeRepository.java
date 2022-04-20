package swd22.GameLibrary.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AttributeRepository extends CrudRepository<Attribute, Long> {
	List<Attribute> findByName(String name);

	Attribute findById(long i);
	
}
