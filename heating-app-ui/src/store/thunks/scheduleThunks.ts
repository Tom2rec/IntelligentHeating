import { createAsyncThunk } from "@reduxjs/toolkit";
import { CreateReservation, Reservation, Reservations } from "../../models/Schedule";
import HttpService from "../../services/HttpService";

const { client } = HttpService;

export const getReservations = createAsyncThunk<Reservations, {id: string, dateFrom: Date, dateTo: Date, status: string}>(
    'schedule/getReservations',
    async ({id, dateFrom, dateTo, status}) => {
        console.log(id)
        const res = await client.get(
            `schedule/room/${id}`, {params: {
                dateFrom: dateFrom.toISOString(),
                dateTo: dateTo.toISOString(),
                status
            }}
        );

        if (res.status === 200)
            return res.data

        throw new Error('schedule/getReservations')
    }
)

export const updateReservation = createAsyncThunk<{reservationDto: Reservation}, {roomId: string, reservation: CreateReservation}>(
    'schedule/addReservation',
    async ({reservation, roomId}) => {
        const res = await client.post(`schedule/room/${roomId}`, reservation);

        if (res.status === 200)
            return res.data

        throw new Error('schedule/addReservation')
    }
)