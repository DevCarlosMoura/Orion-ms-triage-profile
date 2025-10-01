package io.github.DevCarlosMoura.mstriageprofile.model;

import java.time.LocalDateTime; 
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "triage_profiles")
@Getter
@Setter

public class TriageProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "product_sku", nullable = false, unique = true, length = 100)
    private String productSku;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profile_component_checklist", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "component", nullable = false)
    private List<String> componentChecklist;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profile_critical_points", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "point", nullable = false)
    private List<String> criticalAnalysisPoints;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
