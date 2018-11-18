package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.domain.User;
import pl.coderslab.dto.UserDto;
import pl.coderslab.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserDto save(UserDto userDto) {
		User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail());
		user = userRepository.save(user);
		return user.toDto();
	}

	public UserDto find(Long userId) {
		return userRepository.findOne(userId).toDto();
	}

	public User update(UserDto userDto) {
		User user = userRepository.findOne(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		return user;
	}

	public boolean remove(Long userId) {
		User user = userRepository.findOne(userId);
		userRepository.delete(user);
		return true;
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}
}