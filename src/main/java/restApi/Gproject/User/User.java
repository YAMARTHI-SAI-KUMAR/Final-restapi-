package restApi.Gproject.User;

import java.util.Collection;
import java.util.Set;


import jakarta.persistence.*;
import lombok.*;



@Data
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String name;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false ,unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String password;
    public boolean isEnabled() {
        return false;
    }
    // public void setRoles(Set<User> singleton) {
    // }
  
    
   

    
    


}
