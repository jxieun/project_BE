package com.baseballweb.auth.repository.guideRepository;

import com.baseballweb.auth.domain.guideDomain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
}
