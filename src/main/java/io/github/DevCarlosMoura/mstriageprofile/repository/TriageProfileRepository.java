package io.github.DevCarlosMoura.mstriageprofile.repository;

import io.github.DevCarlosMoura.mstriageprofile.model.TriageProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TriageProfileRepository extends JpaRepository<TriageProfile, UUID> {
}
