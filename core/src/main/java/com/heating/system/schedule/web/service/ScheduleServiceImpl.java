package com.heating.system.schedule.web.service;

import com.heating.system.commons.exception.ReservationNotFoundException;
import com.heating.system.commons.exception.RoomNotFoundException;
import com.heating.system.commons.exception.UserNotFoundException;
import com.heating.system.infrastructure.repository.RoomRepository;
import com.heating.system.schedule.mapper.ReservationMapper;
import com.heating.system.schedule.model.Reservation;
import com.heating.system.schedule.model.dto.ReservationDto;
import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.schedule.model.request.ScheduleRoomRequest;
import com.heating.system.schedule.repository.ReservationRepository;
import com.heating.system.schedule.web.service.contract.ScheduleService;
import com.heating.system.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ReservationRepository reservationRepository;
    private final ScheduleValidator scheduleValidator;
    private final ReservationMapper reservationMapper;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;


    @Override
    public List<ReservationDto> getScheduleRoomInfo(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, ReservationStatus status) {
        return reservationRepository.getReservationsByRoomIdAndDatesAndReservationStatus(roomId, dateFrom, dateTo, status).stream()
                .map(reservationMapper::mapToReservationDto)
                .toList();
    }

    @Override
    public List<ReservationDto> getScheduleRoomInfoForGivenUser(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, UUID userId) {
        return reservationRepository.getReservationsByRoomIdAndDatesAndUserId(roomId, dateFrom, dateTo, userId).stream()
                .map(reservationMapper::mapToReservationDto)
                .toList();
    }

    @Override
    public ReservationDto scheduleRoom(UUID roomId, ScheduleRoomRequest request) {
        scheduleValidator.validateCanSchedule(request.getDateFrom(), request.getDateTo());
        var user = userRepository.getUserById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found!"));
        var room = roomRepository.getRoomById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room not found!"));
        var reservation = new Reservation();
        reservation.setReservationStatus(ReservationStatus.PENDING);
        reservation.setDateFrom(request.getDateFrom());
        reservation.setDateTo(request.getDateTo());
        reservation.setUser(user);
        reservation.setRoom(room);
        var createdReservation = reservationRepository.saveAndFlush(reservation);
        return reservationMapper.mapToReservationDto(createdReservation);
    }

    @Override
    @Transactional
    public ReservationDto acceptReservation(UUID reservationId) {
        var reservation = getReservation(reservationId);
        scheduleValidator.validateCanAcceptReservation(reservation);
        reservation.setReservationStatus(ReservationStatus.ACCEPTED);
        return reservationMapper.mapToReservationDto(reservation);
    }

    @Override
    @Transactional
    public ReservationDto rejectReservation(UUID reservationId) {
        var reservation = getReservation(reservationId);
        scheduleValidator.validateCanRejectReservation(reservation);
        reservation.setReservationStatus(ReservationStatus.REJECTED);
        return reservationMapper.mapToReservationDto(reservation);
    }

    @Override
    @Transactional
    public ReservationDto deleteReservation(UUID reservationId) {
        var reservation = getReservation(reservationId);
        scheduleValidator.validateCanDeleteReservation(reservation);
        reservation.setReservationStatus(ReservationStatus.DELETED);
        return reservationMapper.mapToReservationDto(reservation);
    }

    private Reservation getReservation(UUID reservationId) {
        return reservationRepository.getReservationById(reservationId)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation Not Found!"));
    }


}
