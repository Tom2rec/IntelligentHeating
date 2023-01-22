import { useEffect } from "react";
import L from 'leaflet'
import { BuildingDetails } from "../models/Infrastructure";

const Map = ({ buildingDetails, callback }: { buildingDetails: BuildingDetails, callback: (roomId) => void}) => {
    useEffect(() => {
        const roomStyle = {
            color: 'black',
            opacity: 0,
            fillColor: 'white',
            fillOpacity: 1
        };

        const wallStyle = {
            color: 'black',
            fillColor: 'none',
            weight: 3,
            fillOpacity: 1
        };

        const highlight = {
            color: 'red',
            opacity: 0,
            fillColor: 'red',
            fillOpacity: .5,
            weight: 2,
        };

        const layers = buildingDetails.building.floors.map(f => {
            const walls = L.polyline(f.walls, wallStyle).bindPopup("First Floor");
            const layer = buildingDetails.building.rooms
                .filter(r => r.floorNumber === f.floorNumber)
                .map(r => L.polygon(r.walls, roomStyle)
                    .bindTooltip(r.description, { permanent: true, direction: "center", className: 'tooltipclass' })
                    .openTooltip()
                    .on('click', () => callback(r.roomId)));
                
            return L.layerGroup([...layer, walls]);
        })

        const map = L.map('map', {
            crs: L.CRS.Simple,
            minZoom: 0,
            layers: [layers[0]],
        });

        map.setView([25.25, 9], 4);

        layers.forEach(l => l.eachLayer((layer) => {
            if (layer instanceof L.Polygon) {
                layer.on('mouseover', function (e) {
                    layer.setStyle(highlight);
                    //			layer.bringToFront();
                });
                layer.on('mouseout', function (e) {
                    layer.setStyle(roomStyle);
                    //			layer.bringToBack();
                });
            }
        }))

        const baseMaps = {};
        let floorNumber = 1;

        layers.forEach(l => {
            baseMaps[`Level ${floorNumber}`] = l
            floorNumber += 1;
        })

        L.control.layers(baseMaps, null, { collapsed: false }).addTo(map); // eslint-disable-line react-hooks/exhaustive-deps

    }, [])

    return (
        <div id="map"></div>
    )
} 

export default Map