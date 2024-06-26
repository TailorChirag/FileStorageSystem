package chiragtailor.tech.filestoragesystem.controller;


import chiragtailor.tech.filestoragesystem.Exceptions.UsernameNotFoundException;
import chiragtailor.tech.filestoragesystem.dtos.LoginRequestDto;
import chiragtailor.tech.filestoragesystem.dtos.SignUpRequestDto;
import chiragtailor.tech.filestoragesystem.models.User;
import chiragtailor.tech.filestoragesystem.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody() SignUpRequestDto request)  {

        String name = request.getName();
        String email = request.getEmail();
        String password = request.getPassword();

        return userService.signUp(name,email,password);
    }


    @PostMapping("/login")
    public User login(@RequestBody() LoginRequestDto requestDto) throws UsernameNotFoundException {
        return userService.login(requestDto.getEmail(), requestDto.getPassword());
    }
}
