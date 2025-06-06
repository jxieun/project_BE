package com.baseballweb.auth.repository;


import com.baseballweb.auth.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {}