package com.iammahbubalam.rest.identity.repository;

import com.iammahbubalam.rest.identity.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, UUID> {

    /**
     * Finds a RefreshToken by its token string.
     *
     * @param token the token string to search for
     * @return an Optional containing the RefreshToken if found, or empty if not found
     */
    Optional<RefreshToken> findByToken(String token);

    /**
     * Deletes a RefreshToken by its token string.
     *
     * @param token the token string to delete
     */
    void deleteByToken(String token);

    void deleteRevokedTokensByUserId(UUID userId);
    void deleteExpiredTokensByUserId(UUID userId);
    void deleteAllByUserId(UUID userId);
    void deleteExpiredTokensByUserIdAndCreatedAtBefore(UUID userId, Instant createdAt);
}
