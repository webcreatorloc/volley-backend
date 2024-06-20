package com.teamplayer11.player.player;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;

   public PlayerController(PlayerRepository playerRepository) {
       this.playerRepository = playerRepository;
   }

    @GetMapping("/players")
    public List<Player> getPlayers() {
       return (List<Player>) playerRepository.findAll();
    }

    @PostMapping("/player")
    void addPlayer(@RequestBody Player Player) {
        playerRepository.save(Player);
    }
}
