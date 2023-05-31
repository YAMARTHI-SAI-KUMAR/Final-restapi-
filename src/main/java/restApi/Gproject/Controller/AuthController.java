package restApi.Gproject.Controller;

import java.util.Collections;

// import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restApi.Gproject.Dto.LoginDto;
import restApi.Gproject.Dto.SignUpDto;
// import restApi.Gproject.Repositories.RoleRepo;
import restApi.Gproject.Repositories.UserRepo;
// import restApi.Gproject.User.Role;
import restApi.Gproject.User.User;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
     
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepository;

    // @Autowired
    // private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));
                 // Retrieve the authenticated user details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
  

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        // User users= userRepository.findByName("User").get();
        //  user.setRoles(Collections.singleton(users));
       
         userRepository.save(user);
       
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    
    }

    
}
