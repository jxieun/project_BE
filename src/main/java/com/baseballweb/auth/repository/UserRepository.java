
package com.baseballweb.auth.repository;

import com.baseballweb.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//DB접근, 도메인 객체를 DB에 저장하고 관리
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
