package pl.coderslab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.coderslab.domain.Tweet;
import pl.coderslab.dto.TweetDto;
import pl.coderslab.repository.TweetRepository;

@Service
public class TweetService {

	private final TweetRepository tweetRepository;

	@Autowired
	public TweetService(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public TweetDto save(TweetDto tweetDto) {

		Tweet tweet = new Tweet(tweetDto.getTitle(), tweetDto.getTweetText(), tweetDto.getCreated(),
				tweetDto.getUser());

		tweet = tweetRepository.save(tweet);
		return tweet.toDto();

	}

	public TweetDto find(Long tweetId) {
		return tweetRepository.findOne(tweetId).toDto();
	}

	public Tweet update(TweetDto tweetDto) {
		Tweet tweet = tweetRepository.findOne(tweetDto.getId());

		tweet.setTitle(tweetDto.getTitle());
		tweet.setTweetText(tweetDto.getTweetText());
		tweet.setCreated(tweetDto.getCreated());
		tweet.setUser(tweet.getUser());
		return tweet;
	}

	public boolean remove(Long tweetId) {
		Tweet tweet = tweetRepository.findOne(tweetId);
		tweetRepository.delete(tweet);
		return true;
	}

	public List<Tweet> getAll() {
		return tweetRepository.findAll();
	}

}
