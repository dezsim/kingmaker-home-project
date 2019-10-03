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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Player player = playerRepository.findByUsername(s);
        if (player == null) {
            throw new UsernameNotFoundException(s);
        }
        System.out.println(player.getUsername() + "load");
        return new User(s, player.getPassword(), List.of(new SimpleGrantedAuthority(player.getRole())));
    }

    public void savePlayer(Player user) {
        var player = new Player();
        if(user.getUsername().isEmpty() || user.getPassword().isEmpty()){
            throw new IllegalArgumentException("nincs pw vagy username");
        }
        player.setUsername(user.getUsername());
        System.out.println("saveP" + user.getPassword());
        player.setPassword(passwordEncoder.encode(user.getPassword()));
        player.setRole("USER");
        playerRepository.save(player);
    }
}
