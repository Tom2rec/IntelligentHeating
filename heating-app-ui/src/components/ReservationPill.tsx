import { format } from "date-fns"
import { useState } from "react";
import { Reservation, reservationTypes } from "../models/Schedule"

export const ReservationPill = ({reservation}: {reservation: Reservation}) => {
    const [selectedReservationType, setSelectedReservationType] = useState<string>();

    return (
        <div className="rounded-lg bg-light p-2 shadow w-100">
            <div>
                For: {reservation.fullName} ({reservation.email})
            </div>
            <div className="d-flex flex-column gap-2">
                <label htmlFor="dateFrom">Since</label>
                {format(Date.parse(reservation.dateFrom.toString()), "yyyy-MM-dd HH:mm")}
                {/* <input name="dateFrom" type="datetime-local" value={format(Date.parse(reservation.dateFrom.toString()), "yyyy-MM-dd'T'HH:mm")}/> */}
                <label htmlFor="dateTo">To</label>
                {format(Date.parse(reservation.dateTo.toString()), "yyyy-MM-dd HH:mm")}
                {/* <input name="dateTo" type="datetime-local" value={format(Date.parse(reservation.dateTo.toString()), "yyyy-MM-dd'T'HH:mm")} /> */}
            </div>
            <label htmlFor="status" className="mt-2">Status</label>
            <div className="dropdown">
                <button name="status" className="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    {selectedReservationType ?? reservation.status}
                </button>
                <ul className="dropdown-menu">
                    {reservationTypes.map(r => <li id={r} key={r} className="dropdown-item" onClick={e => setSelectedReservationType(e.currentTarget.id)}>{r}</li>)}
                </ul>
            </div>
            <div className="d-flex mt-2 gap-2 justify-content-between">
                <button className="btn btn-primary w-100">Update</button>   
            </div>
        </div>
    )
}
