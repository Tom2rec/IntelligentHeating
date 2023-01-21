-- liquibase formatted sql

-- changeset jwozniak:1674327033727-1
ALTER TABLE heatingsystem.room
    ADD room_json_path VARCHAR(255);

-- changeset jwozniak:1674327033727-2
ALTER TABLE heatingsystem.building DROP CONSTRAINT "FKqgpjpkradllai2jhpmyp5clww";

-- changeset jwozniak:1674327033727-3
ALTER TABLE heatingsystem.building DROP COLUMN building_id;

