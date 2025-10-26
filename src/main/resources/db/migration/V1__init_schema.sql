-- Initial schema creation for blood pressure tracking application
-- Compatible with H2 and PostgreSQL

CREATE TABLE blood_pressure_readings (
    id BIGSERIAL PRIMARY KEY,
    user_id VARCHAR(255),
    date TIMESTAMP NOT NULL,
    systolic INTEGER NOT NULL,
    diastolic INTEGER NOT NULL,
    pulse INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Index on date for faster queries
CREATE INDEX idx_blood_pressure_readings_date ON blood_pressure_readings(date);

-- Index on user_id for faster user-specific queries
CREATE INDEX idx_blood_pressure_readings_user_id ON blood_pressure_readings(user_id);
