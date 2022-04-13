package swd22.GameLibrary;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd22.GameLibrary.domain.Attribute;
import swd22.GameLibrary.domain.AttributeRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AttributeRepositoryTest {
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	 @Test
	 public void findByName() {
		 List<Attribute> attributes = attributeRepository.findByName("Co-op");
		 assertThat(attributes).hasSize(1);
	 }
	 
	 @Test
	 public void createAttribute(){
		 Attribute attribute = new Attribute("Platformer");
		 attributeRepository.save(attribute);
		 assertThat(attribute.getId()).isNotNull();
	 }
}

