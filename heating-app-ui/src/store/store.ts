import { configureStore } from "@reduxjs/toolkit";
import InfrastructureReducer from "./slices/infrastructureSlice"
import ScheduleReducer from "./slices/scheduleSlice"

const store = configureStore({
    reducer: {
        infrastructure: InfrastructureReducer,
        schedule: ScheduleReducer
    },
    middleware: (gDM) => gDM()
})

export default store

export type RootState = ReturnType<typeof store.getState>
export type AppDispatch = typeof store.dispatch