-- liquibase formatted sql

-- changeset tomasz:1669751473882-1
CREATE TABLE heatingsystem.building
(
    id            UUID NOT NULL,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    description   VARCHAR(255),
    faculty_id    UUID,
    building_id   UUID,
    CONSTRAINT "buildingPK" PRIMARY KEY (id)
);

-- changeset tomasz:1669751473882-2
CREATE TABLE heatingsystem.faculty
(
    id            UUID NOT NULL,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    name          VARCHAR(255),
    CONSTRAINT "facultyPK" PRIMARY KEY (id)
);

-- changeset tomasz:1669751473882-3
CREATE TABLE heatingsystem.room
(
    id                                         UUID NOT NULL,
    creation_date                              TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date                                TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    connected_wall_width_in_meters             FLOAT8,
    description                                VARCHAR(255),
    height_in_meters                           FLOAT8,
    not_connected_wall_length_in_meters        FLOAT8,
    radiation_power_in_watts_per_square_meters FLOAT8,
    thermal_conductivity                       FLOAT8,
    wall_thickness                             FLOAT8,
    building_id                                UUID,
    room_id                                    UUID,
    CONSTRAINT "roomPK" PRIMARY KEY (id)
);

-- changeset tomasz:1669751473882-4
CREATE TABLE heatingsystem.room_neighbour_rooms
(
    room_id            UUID NOT NULL,
    neighbour_rooms_id UUID NOT NULL
);

-- changeset tomasz:1669751473882-5
CREATE TABLE heatingsystem.room_temperature_info
(
    id                     UUID NOT NULL,
    creation_date          TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date            TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    is_radiator_on         BOOLEAN,
    room_id                UUID,
    temperature_in_celsius FLOAT8,
    CONSTRAINT "room_temperature_infoPK" PRIMARY KEY (id)
);

-- changeset tomasz:1669751473882-6
ALTER TABLE heatingsystem.room_neighbour_rooms
    ADD CONSTRAINT "UK_kd1gg5ikyvj1hjo9veu5t9d31" UNIQUE (neighbour_rooms_id);

-- changeset tomasz:1669751473882-7
ALTER TABLE heatingsystem.room
    ADD CONSTRAINT "FK4kmfw73x2vpfymk0ml875rh2q" FOREIGN KEY (building_id) REFERENCES heatingsystem.building (id);

-- changeset tomasz:1669751473882-8
ALTER TABLE heatingsystem.building
    ADD CONSTRAINT "FKfy5hf0an5tx0evrj998f9r0ps" FOREIGN KEY (faculty_id) REFERENCES heatingsystem.faculty (id);

-- changeset tomasz:1669751473882-9
ALTER TABLE heatingsystem.room_neighbour_rooms
    ADD CONSTRAINT "FKjg9qsa1opomabvci1svh7xctc" FOREIGN KEY (room_id) REFERENCES heatingsystem.room (id);

-- changeset tomasz:1669751473882-10
ALTER TABLE heatingsystem.room
    ADD CONSTRAINT "FKjt2m842c1nhn15i7lvu583fgj" FOREIGN KEY (room_id) REFERENCES heatingsystem.building (id);

-- changeset tomasz:1669751473882-11
ALTER TABLE heatingsystem.building
    ADD CONSTRAINT "FKqgpjpkradllai2jhpmyp5clww" FOREIGN KEY (building_id) REFERENCES heatingsystem.faculty (id);

-- changeset tomasz:1669751473882-12
ALTER TABLE heatingsystem.room_neighbour_rooms
    ADD CONSTRAINT "FKquljmimru5c56eo02imapi4av" FOREIGN KEY (neighbour_rooms_id) REFERENCES heatingsystem.room (id);
