import { LatLng } from "leaflet"

export interface Faculties {
    faculties: Faculty[]
}

export interface Buildings {
    buildings: Building[]
}

export interface Faculty {
    facultyId: string,
    name: string
}

export interface Building {
    buildingId: string,
    description: string,
}

export interface BuildingDetails {
    building: {
        buildingId: string,
        description: string,
        floors: [Floor],
        rooms: [Room]
    }
}

export interface Floor {
    floorNumber: number,
    walls: L.LatLngExpression[]
}

export interface Room {
    roomId: string,
    description: string,
    floorNumber: number,
    walls: L.LatLngExpression[]
}