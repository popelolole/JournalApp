package se.kthraven.journalapp.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.kthraven.journalapp.Model.classes.CustomUserDetails;
import se.kthraven.journalapp.Model.classes.Person;
import se.kthraven.journalapp.Persistence.IUserPersistence;
import se.kthraven.journalapp.Persistence.entities.UserDB;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserPersistence userPersistence;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDB user = userPersistence.getUserByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found with username: " + username);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
        return new CustomUserDetails(user.getUsername(), user.getPassword(), true, authorities, Person.from(user.getPerson()));
    }
}