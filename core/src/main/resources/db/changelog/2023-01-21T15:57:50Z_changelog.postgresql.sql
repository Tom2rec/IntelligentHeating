-- liquibase formatted sql

-- changeset jwozniak:1674316675157-1
CREATE TABLE heatingsystem.floor
(
    id              UUID NOT NULL,
    creation_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date     TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    floor_json_path VARCHAR(255),
    floor_number    INTEGER,
    building_id     UUID,
    CONSTRAINT "floorPK" PRIMARY KEY (id)
);

-- changeset jwozniak:1674316675157-2
ALTER TABLE heatingsystem.room
    ADD floor_id UUID;

-- changeset jwozniak:1674316675157-3
ALTER TABLE heatingsystem.floor
    ADD CONSTRAINT "FKfvb11l7lpgqc6qdrg3bm24kr3" FOREIGN KEY (building_id) REFERENCES heatingsystem.building (id);

-- changeset jwozniak:1674316675157-4
ALTER TABLE heatingsystem.room
    ADD CONSTRAINT "FKstlo96g0nkwp4urd4e0ki5b3h" FOREIGN KEY (floor_id) REFERENCES heatingsystem.floor (id);

