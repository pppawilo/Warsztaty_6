package pl.coderslab.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.coderslab.domain.User;
import pl.coderslab.dto.UserDto;
import pl.coderslab.service.TweetService;
import pl.coderslab.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;
	private TweetService tweetService;

	public UserController(UserService userService, TweetService tweetService) {
		this.userService = userService;
		this.tweetService = tweetService;

	}

	@RequestMapping(path = "/{id}/tweets", method = RequestMethod.GET)
	public String getUserTweets(@PathVariable Long id, Model model) {
		UserDto userDto = userService.find(id);
		model.addAttribute("userDto", userDto);
		return "userTweets";
	}

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public String getUserForm(Model model) {
		model.addAttribute("userDto", new UserDto());

		return "user";
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String postUserForm(@Valid UserDto userDto, BindingResult result) {
		if (result.hasErrors()) {
			return "user";
		}
		this.userService.save(userDto);
		return "redirect:/user/all";
	}

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public ModelAndView getAllUsers(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);

		return new ModelAndView("users");
	}

	@RequestMapping(path = "deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Long id, Model model) {
		userService.remove(id);
		return "users";
	}

}
