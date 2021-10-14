package com.justedlev.games.tictactoe.controller;

import com.justedlev.games.tictactoe.api.Player;
import com.justedlev.games.tictactoe.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @Autowired
    @Qualifier("game-main")
    IGameService game;

    @PostMapping("/next")
    public ResponseEntity<?> setPlayer(@RequestParam(value = "i") int index) {
        game.setNext(index);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/winner")
    public ResponseEntity<?> getWinner() {
        Player p = game.getWinner();
        if (p == null) {
            return ResponseEntity.ok("no winner yet!".toUpperCase());
        }
        return ResponseEntity.ok("Winner: " + p + "!");
    }

    @GetMapping("/square")
    public ResponseEntity<?> getSquare() {
        return ResponseEntity.ok(game.getSquare());
    }

}
