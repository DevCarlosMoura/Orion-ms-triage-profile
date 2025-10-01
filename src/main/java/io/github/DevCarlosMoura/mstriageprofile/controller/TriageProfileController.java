package io.github.DevCarlosMoura.mstriageprofile.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.DevCarlosMoura.mstriageprofile.model.TriageProfile;
import io.github.DevCarlosMoura.mstriageprofile.repository.TriageProfileRepository;

@RestController
@RequestMapping("/api/v1/triage-profiles")
public class TriageProfileController {

    @Autowired
    private TriageProfileRepository triageProfileRepository;

    @PostMapping
    public ResponseEntity<TriageProfile> createProfile(@RequestBody TriageProfile profile) {
        TriageProfile savedProfile = triageProfileRepository.save(profile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TriageProfile>> getAllProfiles() {
        List<TriageProfile> profiles = triageProfileRepository.findAll();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TriageProfile> getProfileById(@PathVariable UUID id) {
       return triageProfileRepository.findById(id)
                .map(profile -> ResponseEntity.ok(profile))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TriageProfile> updateProfile(@PathVariable UUID id, @RequestBody TriageProfile profileDetails) {
        return triageProfileRepository.findById(id)
                .map(existingProfile -> {
                    existingProfile.setProductSku(profileDetails.getProductSku());
                    existingProfile.setComponentChecklist(profileDetails.getComponentChecklist());
                    existingProfile.setCriticalAnalysisPoints(profileDetails.getCriticalAnalysisPoints());

                    TriageProfile updatedProfile = triageProfileRepository.save(existingProfile);
                    return ResponseEntity.ok(updatedProfile);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable UUID id) {
        if (!triageProfileRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
                triageProfileRepository.deleteById(id);
                return ResponseEntity.noContent().build();
    }
}