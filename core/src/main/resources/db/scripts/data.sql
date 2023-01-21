BEGIN;

-- faculty
INSERT INTO heatingsystem.faculty(id, creation_date, update_date, name)
VALUES ('71474bae-99a6-11ed-a8fc-0242ac120002', now(), now(), 'EAIIB');

-- building
INSERT INTO heatingsystem.building(id, creation_date, update_date, description, faculty_id)
VALUES ('f7c287ba-99ac-11ed-a8fc-0242ac120002', now(), now(), 'C2', '71474bae-99a6-11ed-a8fc-0242ac120002');

-- floor
INSERT INTO heatingsystem.floor(id, creation_date, update_date, floor_json_path, floor_number, building_id)
VALUES ('e7e840fe-99ad-11ed-a8fc-0242ac120002', now(), now(), 'building_1_floor_1.json', 1, 'f7c287ba-99ac-11ed-a8fc-0242ac120002'),
       ('109b304c-99ae-11ed-a8fc-0242ac120002', now(), now(), 'building_1_floor_2.json', 2, 'f7c287ba-99ac-11ed-a8fc-0242ac120002');

INSERT INTO heatingsystem.room(id, creation_date, update_date, connected_wall_width_in_meters, description, height_in_meters, not_connected_wall_length_in_meters,
                               radiation_power_in_watts_per_square_meters, thermal_conductivity, wall_thickness, building_id,floor_id, room_json_path)
VALUES ('7e951bd0-99ae-11ed-a8fc-0242ac120002', now(), now(), 6.0, 'C2:101', 2.0, 10.0, 10000.0, 0.26, 0.2, 'f7c287ba-99ac-11ed-a8fc-0242ac120002', 'e7e840fe-99ad-11ed-a8fc-0242ac120002', 'room_1.json'),
       ('580db401-0553-4cb0-a812-9431f2960510', now(), now(), 6.0, 'C2:102', 2.0, 10.0, 1.0, 0.26, 0.2, 'f7c287ba-99ac-11ed-a8fc-0242ac120002', 'e7e840fe-99ad-11ed-a8fc-0242ac120002', 'room_2.json');

INSERT INTO heatingsystem.room_temperature_info(room_id, creation_date, update_date, is_radiator_on, id, temperature_in_celsius)
VALUES ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:20:50.509628', '2022-12-02T10:20:50.509628', true, '63e93d9a-99b1-11ed-a8fc-0242ac120002', 1.1020408163265074),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:20:50.509628', '2022-12-02T10:20:50.509628', false,'63e9477c-99b1-11ed-a8fc-0242ac120002',  1.0000183256976243),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:25:50.509628', '2022-12-02T10:25:50.509628', true, '63e94948-99b1-11ed-a8fc-0242ac120002', 1.2040031251569872),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:25:50.509628', '2022-12-02T10:25:50.509628', false,'63e94baa-99b1-11ed-a8fc-0242ac120002',  1.0000447526631433),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:30:50.509628', '2022-12-02T10:30:50.509628', true, '63e94d62-99b1-11ed-a8fc-0242ac120002', 1.3058869875389405),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:30:50.509628', '2022-12-02T10:30:50.509628', false,'63e94f38-99b1-11ed-a8fc-0242ac120002',  1.0000792684198245),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:35:50.509628', '2022-12-02T10:35:50.509628', true, '63e95168-99b1-11ed-a8fc-0242ac120002', 1.4076924644719497),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:35:50.509628', '2022-12-02T10:35:50.509628', false,'63e9564a-99b1-11ed-a8fc-0242ac120002',  1.0001218605053737),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:40:50.509628', '2022-12-02T10:40:50.509628', true, '63e957c6-99b1-11ed-a8fc-0242ac120002', 1.5094196169075644),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:40:50.509628', '2022-12-02T10:40:50.509628', false,'63e958f2-99b1-11ed-a8fc-0242ac120002',  1.0001725164719915),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:45:50.509628', '2022-12-02T10:45:50.509628', true, '63e95a14-99b1-11ed-a8fc-0242ac120002', 1.6110685057495289),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:45:50.509628', '2022-12-02T10:45:50.509628', false,'63e95b36-99b1-11ed-a8fc-0242ac120002',  1.000231223886317),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:50:50.509628', '2022-12-02T10:50:50.509628', true, '63e95c58-99b1-11ed-a8fc-0242ac120002', 1.7126391918537252),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:50:50.509628', '2022-12-02T10:50:50.509628', false,'63e95d70-99b1-11ed-a8fc-0242ac120002',  1.0002979703293136),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T10:55:50.509628', '2022-12-02T10:55:50.509628', true, '63e95f1e-99b1-11ed-a8fc-0242ac120002', 1.81413173602823),
       ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '2022-12-02T10:55:50.509628', '2022-12-02T10:55:50.509628', false,'63e96360-99b1-11ed-a8fc-0242ac120002',  1.00037274339644),
       ('580db401-0553-4cb0-a812-9431f2960510', '2022-12-02T11:00:50.509628', '2022-12-02T11:00:50.509628', true, '63e9650e-99b1-11ed-a8fc-0242ac120002', 1.915546199033372);

INSERT INTO heatingsystem.room_neighbour_rooms(room_id, neighbour_rooms_id)
VALUES ('7e951bd0-99ae-11ed-a8fc-0242ac120002', '580db401-0553-4cb0-a812-9431f2960510'),
       ('580db401-0553-4cb0-a812-9431f2960510', '7e951bd0-99ae-11ed-a8fc-0242ac120002');

COMMIT;