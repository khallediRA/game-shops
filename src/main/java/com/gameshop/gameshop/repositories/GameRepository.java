package com.gameshop.gameshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gameshop.gameshop.Model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
