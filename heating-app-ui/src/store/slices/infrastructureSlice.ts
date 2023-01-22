import { createSlice, PayloadAction } from "@reduxjs/toolkit"
import { Building, BuildingDetails, Faculty } from "../../models/Infrastructure"
import { RootState } from "../store"
import { getBuildingDetails, getBuildingsInFaculty, getFaculties } from "../thunks/infrastructureThunks"

interface InfrastructureState {
    faculties: Faculty[],
    buildings: Building[],
    selectedBuilding: BuildingDetails | undefined
}

const initialState: InfrastructureState = {
    faculties: [],
    buildings: [],
    selectedBuilding: undefined
}

export const infrastructureSlice = createSlice({
    name: "infrastructure",
    initialState,
    reducers: {
    },
    extraReducers: (builder) => {
        builder.addCase(getFaculties.fulfilled, (state, action) => {
            state.faculties = action.payload.faculties
        })
        builder.addCase(getBuildingsInFaculty.fulfilled, (state, action) => {
            state.buildings = action.payload.buildings
        })
        builder.addCase(getBuildingDetails.fulfilled, (state, action) => {
            state.selectedBuilding = action.payload
        })
        builder.addCase(getBuildingDetails.pending, (state) => {
            state.selectedBuilding = undefined
        })
    }
})

export const selectFaculties = (state: RootState) => state.infrastructure.faculties;
export const selectBuildings = (state: RootState) => state.infrastructure.buildings;
export const selectCurrentSelectedBuilding = (state: RootState) => state.infrastructure.selectedBuilding;

export const {

} = infrastructureSlice.actions

export default infrastructureSlice.reducer