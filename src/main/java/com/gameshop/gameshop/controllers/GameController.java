package com.gameshop.gameshop.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gameshop.gameshop.DTO.GameDTO;
import com.gameshop.gameshop.Model.Game;
import com.gameshop.gameshop.services.GameService;

@RestController
@RequestMapping("games-api")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/add-game")
    public ResponseEntity<Game> addGame(@ModelAttribute GameDTO gameDTO) throws IOException, Exception {
        return new ResponseEntity<Game>(gameService.saveGame(gameDTO), HttpStatus.CREATED);
    }

    @GetMapping("getAllGames")
    public List<Game> getAllListOfGame() {
        return gameService.getAllGames();
    }

    @GetMapping("getGameById/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long gameId) {
        try {
            return new ResponseEntity<Game>(gameService.getGameById(gameId), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        }
    }
}
