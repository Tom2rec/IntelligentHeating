-- liquibase formatted sql

-- changeset tomasz:1674738193784-1
ALTER TABLE heatingsystem.room
    ADD is_radiator_on BOOLEAN NOT NULL;

-- changeset tomasz:1674738193784-2
ALTER TABLE heatingsystem.room
    ADD temperature_in_celsius FLOAT8 NOT NULL;

-- changeset tomasz:1674738193784-3
ALTER TABLE heatingsystem.room_neighbour_rooms DROP CONSTRAINT "UK_kd1gg5ikyvj1hjo9veu5t9d31";

