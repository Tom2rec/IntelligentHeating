import { Dispatch } from '@reduxjs/toolkit';
import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { Building } from '../models/Infrastructure';
import { reservationTypes } from '../models/Schedule';
import { selectBuildings, selectCurrentSelectedBuilding, selectFaculties } from '../store/slices/infrastructureSlice';
import { selectReservations } from '../store/slices/scheduleSlice';
import { AppDispatch } from '../store/store';
import { getBuildingDetails, getBuildingsInFaculty, getFaculties } from '../store/thunks/infrastructureThunks';
import { getReservations } from '../store/thunks/scheduleThunks';
import Map from './Map';
import { ReservationPill } from './ReservationPill';

const Home = () => {
    const dispatch = useDispatch<AppDispatch>();
    const today = new Date()

    const faculties = useSelector(selectFaculties)
    const buildings = useSelector(selectBuildings)
    const selectedBuilding = useSelector(selectCurrentSelectedBuilding);
    const reservations = useSelector(selectReservations);

    const [selectedFacultyId, setSelectedFacultyId] = useState<string>();
    const [selectedBuildingId, setSelectedBuildingId] = useState<string>();
    const [selectedReservationType, setSelectedReservationType] = useState<string>();
    const [selectedRoomId, setSelectedRoomId] = useState<string>();

    useEffect(() => {
        if (!!selectedBuildingId)
            dispatch(getBuildingDetails(selectedBuildingId))
    }, [selectedBuildingId])

    useEffect(() => {
        if (!!selectedReservationType) 
            dispatch(getReservations({
                id: selectedRoomId,
                dateFrom: new Date(today.getFullYear(), today.getMonth(), 1),
                dateTo: new Date(today.getMonth() <= 11 ? today.getFullYear() : today.getFullYear() + 1, today.getMonth() + 1, 0),
                status: selectedReservationType
            }))
    }, [selectedReservationType])

    useEffect(() => {
        if (!!selectedFacultyId)
            dispatch(getBuildingsInFaculty(selectedFacultyId))
    }, [selectedFacultyId])

    useEffect(() => {
        dispatch(getFaculties())
    }, [])

    const openRoomDetailsSidebar = (roomId: string) => {
        setSelectedRoomId(roomId)
        dispatch(getReservations({
            id: roomId,
            dateFrom: new Date(today.getFullYear(), today.getMonth(), 1), 
            dateTo: new Date(today.getMonth() <= 11 ? today.getFullYear() : today.getFullYear() + 1, today.getMonth() + 1, 0),
            status: "PENDING"
        }))
    }

    return (
        <div className="container-fluid d-flex">
            {!!selectedBuilding && <Map buildingDetails={selectedBuilding} callback={openRoomDetailsSidebar} />}
            <div className="sidebar p-2">
                <h3>Building</h3>
                <div className='d-flex gap-2'>
                    {faculties?.length > 0 &&
                        <div className="dropdown">
                            <button className="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                {faculties.find(f => f.facultyId === selectedFacultyId)?.name ?? 'select faculty'}
                            </button>
                            <ul className="dropdown-menu">
                                {faculties.map(f => <li key={f.facultyId} id={f.facultyId} className="dropdown-item" onClick={e => setSelectedFacultyId(e.currentTarget.id)}>{f.name}</li>)}
                            </ul>
                        </div>
                    }
                    {buildings?.length > 0 &&
                        <div className="dropdown">
                            <button className="btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                {buildings.find(b => b.buildingId === selectedBuildingId)?.description ?? 'select building'}
                            </button>
                            <ul className="dropdown-menu">
                                {buildings.map(b => <li key={b.buildingId} id={b.buildingId} className="dropdown-item" onClick={e => setSelectedBuildingId(e.currentTarget.id)}>{b.description}</li>)}
                            </ul>
                        </div>
                    }
                </div>
                <h3>Temperature</h3>
                <div>22.3 C, last update: 2022-12-01 12:22</div>
                {reservations?.length > 0 &&
                <div className="mt-2">
                    <div className="d-flex gap-2">
                        <h3>Reservations</h3>
                        {reservations?.length > 0 &&
                            <div className="dropdown">
                                <button className="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    {selectedReservationType ?? "PENDING"}
                                </button>
                                <ul className="dropdown-menu">
                                    {reservationTypes.map(r => <li id={r} key={r} className="dropdown-item" onClick={e => setSelectedReservationType(e.currentTarget.id)}>{r}</li>)}
                                </ul>
                            </div>
                        }
                    </div>
                    <div className="overflow-y-scroll reservations-grid">
                        {reservations.map(r => <ReservationPill key={r.reservationId} reservation={r}/>)}
                    </div>
                </div>
                }
            </div>
        </div>
    )


}

export default Home
