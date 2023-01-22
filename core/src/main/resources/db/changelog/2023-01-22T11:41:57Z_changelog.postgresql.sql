-- liquibase formatted sql

-- changeset jwozniak:1674387722193-1
CREATE TABLE heatingsystem.reservation
(
    id                 UUID NOT NULL,
    creation_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date        TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    date_from          TIMESTAMP WITHOUT TIME ZONE,
    date_to            TIMESTAMP WITHOUT TIME ZONE,
    reservation_status VARCHAR(255),
    room_id            UUID,
    user_id            UUID,
    CONSTRAINT "reservationPK" PRIMARY KEY (id)
);

-- changeset jwozniak:1674387722193-2
ALTER TABLE heatingsystem.reservation
    ADD FOREIGN KEY (user_id) REFERENCES heatingsystem."user" (id);

-- changeset jwozniak:1674387722193-3
ALTER TABLE heatingsystem.reservation
    ADD FOREIGN KEY (room_id) REFERENCES heatingsystem.room (id);

