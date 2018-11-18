package pl.coderslab.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import pl.coderslab.domain.Tweet;

public class UserDto {

	private Long id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;

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

	public UserDto(Long id, String firstName, String lastName, String email, List<Tweet> tweets) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.tweets = tweets;
	}

	public UserDto() {
	}

}
