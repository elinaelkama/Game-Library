package swd22.GameLibrary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd22.GameLibrary.web.AttributeController;
import swd22.GameLibrary.web.GameLibraryController;
import swd22.GameLibrary.web.PlatformController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class GameLibraryApplicationTests {

	@Autowired
	private GameLibraryController gameController;
	
	@Autowired
	private PlatformController platformController;
	
	@Autowired
	private AttributeController attributeController;

	@Test
	void contextLoads() throws Exception{
		assertThat(gameController).isNotNull();
		assertThat(platformController).isNotNull();
		assertThat(attributeController).isNotNull();
	}
}
