package hu.flowacademy.kingmakerbackend.resource;

import hu.flowacademy.kingmakerbackend.model.Player;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Rest {

    @GetMapping("")
    public Player findBy(){
        return new Player();
    }
}
