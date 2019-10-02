package hu.flowacademy.kingmakerbackend.config;

import hu.flowacademy.kingmakerbackend.model.Player;
import hu.flowacademy.kingmakerbackend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class InitDataLoader implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (playerRepository.findByUsername("john") == null) {
            var player = new Player();
            player.setUsername("john");
            player.setPassword(passwordEncoder.encode("123"));
            player.setRole("USER");
            playerRepository.save(player);
        }
    }
}
