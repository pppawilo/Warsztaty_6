package pl.coderslab;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.coderslab.repository.UserRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class JpaConfig {

}
