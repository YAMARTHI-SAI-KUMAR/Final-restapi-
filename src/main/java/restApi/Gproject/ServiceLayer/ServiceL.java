package restApi.Gproject.ServiceLayer;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import restApi.Gproject.Repositories.UserRepo;
import restApi.Gproject.User.User;

@Service
public class ServiceL implements UserDetailsService{
   
  
    private UserRepo userRepository;

    public ServiceL(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
          User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

        // Set<GrantedAuthority> authorities = user
        //         .getRoles()
        //          .stream()
        //        .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                getAuthorities(user));

    }
  
    
    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        // Assign a default authority to the user
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("User");
        return Collections.singleton(authority);
    }






    // public boolean isEnabled() {
    //     return true;
    // }

    // public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return null;
    // }
 




    // public ServiceL(UserRepo userRepository){
    //     this.userRepository = userRepository;
    // }

    // @Override 
    // public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
    //     User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
    //            .orElseThrow(() ->
    //                    new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

    //     // Set<GrantedAuthority> authorities = user
    //     //                .getRoles()
    //     //                .stream()
    //     //                .map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
       
    //     return new org.springframework.security.core.userdetails.User(user.getEmail(),
    //                    user.getPassword());
    // }

}
