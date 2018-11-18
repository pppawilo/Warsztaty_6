package pl.coderslab.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.coderslab.domain.User;

public class TweetDto {

	private Long id;

	@NotNull
	@Size(min = 5, max = 50)
	private String title;

	@NotNull
	@Size(max = 160)
	private String tweetText;

	private LocalDateTime created;

	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTweetText() {
		return tweetText;
	}

	public void setTweetText(String tweetText) {
		this.tweetText = tweetText;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TweetDto(Long id, String title, String tweetText, LocalDateTime created, User user) {
		super();
		this.id = id;
		this.title = title;
		this.tweetText = tweetText;
		this.created = created;
		this.user = user;
	}

	public TweetDto() {

	}
}
