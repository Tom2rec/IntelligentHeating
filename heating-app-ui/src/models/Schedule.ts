export interface Reservations {
    reservations: [Reservation]
}

export interface Reservation {
    reservationId: string,
    dateFrom: Date,
    dateTo: Date,
    status: string,
    fullName: string,
    email: string
}

export interface CreateReservation {
    dateFrom: string,
    dateTo: string,
    userId: string
}

export const reservationTypes = ["PENDING", "ACCEPTED", "REJECTED", "DELETED"]
