-- liquibase formatted sql

-- changeset jwozniak:1674327750959-1
ALTER TABLE heatingsystem.room DROP CONSTRAINT "FKjt2m842c1nhn15i7lvu583fgj";

-- changeset jwozniak:1674327750959-2
ALTER TABLE heatingsystem.room DROP COLUMN room_id;

