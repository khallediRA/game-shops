package com.gameshop.gameshop.services;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gameshop.gameshop.DTO.GameDTO;
import com.gameshop.gameshop.Model.Game;
import com.gameshop.gameshop.repositories.GameRepository;

import lombok.Value;

@Service
@Transactional

public class GameService {

    private final GameRepository gameRepository;

    private final FileStoringService fileStoringService;

    public GameService(GameRepository gameRepository, FileStoringService fileStoringService) {
        this.gameRepository = gameRepository;
        this.fileStoringService = fileStoringService;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game saveGame(GameDTO gameDTO) throws IOException, Exception {
        Game game = Game.builder().name(gameDTO.getName()).category(gameDTO.getCategory())
                .description(gameDTO.getDescription()).price(gameDTO.getPrice()).build();
        if (gameDTO.getGameimage() != null && !gameDTO.getGameimage().isEmpty()) {
            String imageURL = fileStoringService.save(gameDTO.getGameimage().getBytes(),
                    gameDTO.getGameimage().getOriginalFilename());
            game.setImageUrl(imageURL);
        }

        return gameRepository.save(game);
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find game with id" + id));
    }
}
