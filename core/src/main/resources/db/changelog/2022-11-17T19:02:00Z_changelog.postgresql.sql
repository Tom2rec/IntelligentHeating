-- liquibase formatted sql

-- changeset jwozniak:1668711725695-1
CREATE TABLE heatingsystem.user
(
    id               UUID NOT NULL,
    creation_date    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    update_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    email            VARCHAR(255),
    first_name       VARCHAR(255),
    keycloak_user_id VARCHAR(255),
    last_name        VARCHAR(255),
    CONSTRAINT "userPK" PRIMARY KEY (id)
);

