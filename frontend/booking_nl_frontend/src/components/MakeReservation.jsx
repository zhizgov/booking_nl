
import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import {useNavigate} from 'react-router-dom';
import { toast } from 'react-toastify';
import ReservationService from '../functions/ReservationService';
import DestinationService from '../functions/DestinationService';
import UserService from '../functions/UserService';
import jwtDecode from 'jwt-decode';
import { useParams } from "react-router-dom";


const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1)
      },
    },
  }));


  
export default function MakeReservation(){
    const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}
    const {id}= useParams();
    const[guests, setGuests]=useState('');
    const[destination, setDestination]=useState('');
    const[destinationPrice, setDestinationPrice]=useState('');
    const[user, setUser]=useState('');
    const[startDate, setStartDate]=useState('');
    const[endDate, setEndDate]=useState('');

    

    const classes = useStyles();
    const navigate = useNavigate();
    const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;

    const getUser = () =>
        UserService.getUser(email);

    const getDestination = () =>
        DestinationService.getDestination(id);


    const makeReservation = async () =>{
      const sDate = new Date(startDate);
      const eDate = new Date(endDate);

      // One day in milliseconds
    const oneDay = 1000 * 60 * 60 * 24;

    // Calculating the time difference between two dates
    const diffInTime = sDate.getTime() - eDate.getTime();

    // Calculating the no. of days between two dates
    const diffInDays = Math.round(diffInTime / oneDay);
      const totalPrice=diffInDays*(guests * destinationPrice);
      const reservation={user, destination,  startDate, endDate, guests, totalPrice}
      ReservationService.makeReservation({reservation}).then(res=>{
        navigate("/")
      })}

      
      

      useEffect(()=>{
        //setUser(UserService.getUser(jwtDecode(sessionStorage.getItem("accesstoken")).sub));
        
        
        const role = sessionStorage.getItem("role");
        if (role === "[Admin]") {
         navigate("/");
    
        }

        getDestination().then(res => {
          setDestination(res.data);
          setDestinationPrice(res.data.pricePerNight)
        })
        getUser().then(res => {
          setUser(res.data);
        })
    },[])
    return (
      
        <Container>
            <Paper elevation={3} style={paperStyle}>
                <h1 style={{color:"blue"}}><u>Make a reservation</u></h1>
        <form className={classes.root} noValidate autoComplete="off">
        <TextField  id="date"label="Start Date"type="date"defaultValue="2017-05-24"value={startDate}
    onChange={(e)=>setStartDate(e.target.value)}
    className={classes.textField}
    InputLabelProps={{
      shrink: true,
    }}
  />
          <TextField id="date"label="End Date"type="date"defaultValue="2017-05-24"value={endDate}
    onChange={(e)=>setEndDate(e.target.value)}
    className={classes.textField}
    InputLabelProps={{
      shrink: true,
    }}
  />
           <TextField id="outlined-basic" label="Number of guests" type="number"variant="outlined" fullWidth
          value={guests}
          onChange={(e)=>setGuests(e.target.value)}
          />
          <p className="destination-location"> Total price for number of guests per Night: {destinationPrice}</p>
           <Button onClick={makeReservation} variant="contained" color="secondary" >
     Make reservation
    </Button>
        </form>
        
        </Paper>
        </Container>
        
      );
}