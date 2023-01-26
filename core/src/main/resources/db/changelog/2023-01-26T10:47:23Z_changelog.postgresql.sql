-- liquibase formatted sql

-- changeset jwozniak:1674724527568-1
UPDATE heatingsystem.plant
SET push_interval_in_minutes = 5;

