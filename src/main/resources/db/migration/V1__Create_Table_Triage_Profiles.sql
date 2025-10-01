CREATE TABLE triage_profiles (
    id UUID PRIMARY KEY,
    product_sku VARCHAR(100) NOT NULL UNIQUE,
    component_checklist TEXT[],
    critical_analysis_points TEXT[],
    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);