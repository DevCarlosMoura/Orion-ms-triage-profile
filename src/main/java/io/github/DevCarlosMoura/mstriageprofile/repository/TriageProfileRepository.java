package io.github.DevCarlosMoura.mstriageprofile.repository;

import io.github.DevCarlosMoura.mstriageprofile.model.TriageProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import org.apache.el.stream.Optional;

@Repository
public interface TriageProfileRepository extends JpaRepository<TriageProfile, UUID> {

    Optional<TriageProfile> findByProductSku(String productSku);
}
