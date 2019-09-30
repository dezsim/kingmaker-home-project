package hu.flowacademy.kingmakerbackend.auth;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Player player = playerRepository.findByUsername(s);
        if (player == null) {
            throw new UsernameNotFoundException(s);
        }
        System.out.println(player.getPassword());
        return new User(s, player.getPassword(), List.of(new SimpleGrantedAuthority(player.getRole())));
    }
}
