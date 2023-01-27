import React from "react";
import { Outlet } from "react-router-dom";
import DestinationService from "../functions/DestinationService";
import { ShowAllDestinations } from "./ShowAllDestinations";
import jwtDecode from "jwt-decode";




export const Home = () => {
    return (
        <div className="container text-center py-5">
        
            <ShowAllDestinations destinations = {DestinationService.getAllDestinations().destinations} />
            <Outlet />
        </div>
    );
}
