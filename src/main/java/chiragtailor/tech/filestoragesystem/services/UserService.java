package chiragtailor.tech.filestoragesystem.services;

import chiragtailor.tech.filestoragesystem.Exceptions.UsernameNotFoundException;
import chiragtailor.tech.filestoragesystem.models.User;
import chiragtailor.tech.filestoragesystem.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepositorym,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User signUp(String name,  String email, String password){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setHashedPassord(bCryptPasswordEncoder.encode(password));

        User user1 = userRepository.save(user);


        return user1;
    }

    public User login(String email, String password) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(bCryptPasswordEncoder.matches(password, user.getHashedPassord())){
                return user;
            }
        }
        else {
            throw new UsernameNotFoundException("Username not found");
        }


        return null;
    }
}
