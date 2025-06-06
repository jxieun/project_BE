package com.baseballweb.auth.repository;


import com.baseballweb.auth.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {}