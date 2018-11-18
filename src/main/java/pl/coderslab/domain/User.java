package pl.coderslab.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import pl.coderslab.dto.UserDto;

@Entity
@Table(name = "tweeter_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Tweet> tweets = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User() {

	}

	@Transient
	public UserDto toDto() {
		UserDto userDto = new UserDto();
		userDto.setId(getId());
		userDto.setEmail(getEmail());
		userDto.setFirstName(getFirstName());
		userDto.setLastName(getLastName());
		userDto.setTweets(getTweets());
		return userDto;
	}

}
