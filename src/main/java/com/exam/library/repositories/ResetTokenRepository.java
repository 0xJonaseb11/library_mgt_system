package com.exam.library.repositories;

import com.exam.library.models.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {
    Optional<ResetToken> findByToken(String token);
}
