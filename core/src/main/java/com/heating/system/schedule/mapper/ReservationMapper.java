package com.heating.system.schedule.mapper;

import com.heating.system.schedule.model.Reservation;
import com.heating.system.schedule.model.dto.ReservationDto;
import com.heating.system.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "reservationId", source = "id")
    @Mapping(target = "fullName", source = "reservation.user", qualifiedByName = "toFullName")
    @Mapping(target = "email", source = "reservation.user.email")
    ReservationDto mapToReservationDto(Reservation reservation);

    @Named("toFullName")
    default String toFullName(User user) {
        return String.join(" ", user.getFirstName(), user.getLastName());
    }
}
