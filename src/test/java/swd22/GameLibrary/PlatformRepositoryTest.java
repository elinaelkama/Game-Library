package swd22.GameLibrary;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import swd22.GameLibrary.domain.Platform;
import swd22.GameLibrary.domain.PlatformRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PlatformRepositoryTest {
	
	@Autowired
	PlatformRepository platformRepository;

	@Test
	public void findByName() {
		List<Platform> platforms = platformRepository.findByName("Steam");
		assertThat(platforms).hasSize(1);
	}
	
	@Test
	public void createPlatform() {
		Platform platform = new Platform("JyrgenHyrgen");
		platformRepository.save(platform);
		assertThat(platform.getId()).isNotNull();
	}
}