package com.teamplayer11.player.player;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.teamplayer11.player.VolleyBackendApplication.SEC_ALLOWED_ORIGIN;

@RestController
public class PlayerController {

   // private final PlayerRepository playerRepository;

   //public PlayerController(PlayerRepository playerRepository) {
    //   this.playerRepository = playerRepository;
   //}

    @GetMapping("/hello")
    public String getSecVar() {
       return "Hello " + SEC_ALLOWED_ORIGIN;
    }


   /* @GetMapping("/players")
    public List<Player> getPlayers() {
       return (List<Player>) playerRepository.findAll();
    }

    @PostMapping("/player")
    void addPlayer(@RequestBody Player Player) {
        playerRepository.save(Player);
    }*/
}
