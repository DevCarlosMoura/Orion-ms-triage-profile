CREATE TABLE profile_component_checklist (
    profile_id UUID NOT NULL,
    component VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id, component),
    FOREIGN KEY (profile_id) REFERENCES triage_profiles (id)
);

CREATE TABLE profile_critical_points (
    profile_id UUID NOT NULL,
    point VARCHAR(255) NOT NULL,
    PRIMARY KEY (profile_id, point),
    FOREIGN KEY (profile_id) REFERENCES triage_profiles (id)
);