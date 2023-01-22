import { createAsyncThunk } from "@reduxjs/toolkit";
import { BuildingDetails, Buildings, Faculties } from "../../models/Infrastructure";
import HttpService from '../../services/HttpService'

const { client } = HttpService;

export const getFaculties = createAsyncThunk<Faculties, void>(
    'infrastructure/getFaculties',
    async () => {
        const res = await client.get('all');

        if (res.status === 200)
            return res.data

        throw new Error('infrastructure/getFaculties')
    }
)

export const getBuildingsInFaculty = createAsyncThunk<Buildings, string> (
    'infrastructure/getBuildingsInFaculty',
    async (id) => {
        const res = await client.get(`faculty/${id}/building/all`);

        if (res.status === 200)
            return res.data

        throw new Error('infrastructure/getBuildingsInFaculty')
    }
)

export const getBuildingDetails = createAsyncThunk<BuildingDetails, string>(
    'infrastructure/getBuildingDetails',
    async (id) => {
        const res = await client.get(`building/${id}`);

        if (res.status === 200)
            return res.data

        throw new Error('infrastructure/getBuildingDetails')
    }
)