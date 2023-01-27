import { useEffect } from 'react';
import { useState } from 'react';
import DestinationService from '../functions/DestinationService'
import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Typography from '@material-ui/core/Typography';
import ButtonBase from '@material-ui/core/ButtonBase';
import Button from '@material-ui/core/Button';
import { Link } from 'react-router-dom';
import {useNavigate} from 'react-router-dom';
import SingleDestination from './SingleDestination';
import ReservationService from '../functions/ReservationService';
import UserService from '../functions/UserService';
import jwtDecode from 'jwt-decode';



export default function MyReservations  ()  {
   const [reservations, setReservations] = useState([]);
   const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;
   const [userId, setId] = useState('');
   const navigate = useNavigate();


   const getUser = () =>
   UserService.getUser(email);

   const getReservations = () =>{
   ReservationService.getReservations(userId).then(res => setReservations(res.data));;
   }

   

   useEffect(()=>{
    const role = sessionStorage.getItem("role");
        if (role === "[Admin]") {
         navigate("/");
    
        }

    getUser().then(res => {
      setId(res.data.id)
      // ReservationService.getReservations(userId).then(res => setReservations(res.data));
    })
    
   },[])

  

   //const navigate = useNavigate();
const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(2),
    margin: 'auto',
    maxWidth: 500,
  },
  image: {
    width: 128,
    height: 128,
  },
  img: {
    margin: 'auto',
    display: 'block',
    maxWidth: '100%',
    maxHeight: '100%',
  },
}));   
 return ( 
  
    <div  className="singleDestination">
    
  <button className="show-reservation-button" onClick={getReservations}>Show</button>
  {reservations.map((reservation) => (
   <div className='card-container'>
   
 
        <div key={reservation.id} className = 'card'>
    
     <h2 className="card-name">Starts from {reservation.startDate} until {reservation.endDate}</h2>
     <p className="card-location">Total amount to be paid {reservation.totalPrice} euro (for the whole reservation)</p>
     <p className="card-price">Number of guest on reservation - {reservation.guests}</p>
 </div>

 </div>
    ))}
    </div>
 );


  }