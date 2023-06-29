package employee.example.dn.service;

import employee.example.dn.entity.EmployeeUser;
import employee.example.dn.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
   private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeRepository.findByUsername(username)
                .map(user ->
                        new User(user.getUsername(),
                                user.getPassword(),
                                Collections.singletonList(
                                        new SimpleGrantedAuthority(null))))
                .orElseThrow(() -> new UsernameNotFoundException(username + "NOT FOUND"));
    }
}
