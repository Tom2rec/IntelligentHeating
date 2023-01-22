import { createSlice, PayloadAction } from "@reduxjs/toolkit"
import { Building, BuildingDetails, Faculty } from "../../models/Infrastructure"
import { Reservation, Reservations } from "../../models/Schedule"
import { RootState } from "../store"
import { getReservations } from "../thunks/scheduleThunks"

interface ScheduleState {
    reservations: Reservation[],
}

const initialState: ScheduleState = {
    reservations: [],
}

export const scheduleSlice = createSlice({
    name: "schedule",
    initialState,
    reducers: {
    },
    extraReducers: (builder) => {
        builder.addCase(getReservations.fulfilled, (state, action) => {
            state.reservations = action.payload.reservations
        })
    }
})

export const selectReservations = (state: RootState) => state.schedule.reservations;

export const {

} = scheduleSlice.actions

export default scheduleSlice.reducer