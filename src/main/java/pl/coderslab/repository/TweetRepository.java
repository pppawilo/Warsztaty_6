package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.coderslab.domain.Tweet;
import pl.coderslab.dto.TweetDto;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

	List<TweetDto> findByUserId(Long userId);

}
