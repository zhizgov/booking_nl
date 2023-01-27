import React, {useEffect, useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import DestinationService from '../functions/DestinationService';
import axios from 'axios';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { Home } from './Home';
import {useNavigate} from 'react-router-dom';
import { toast } from 'react-toastify';
import jwtDecode from 'jwt-decode';

const useStyles = makeStyles((theme) => ({
    root: {
      '& > *': {
        margin: theme.spacing(1)
      },
    },
  }));

  
  
  export default function CreateDesination() {
  
    const navigate = useNavigate();
    

    useEffect(()=>{
      const role = sessionStorage.getItem("role");
      if (role !== "[Admin]") {
       navigate("/");
  
      }
  },[])
  
      const paperStyle = {padding: '50px 20px', width:600, margin:"20px auto "}
    const [name, setName]=useState('');
    const [location, setLocation]=useState('');
    const [imageURL, setImageURL]=useState('');
    const [pricePerNight, setPricePerNight]=useState('');
      const classes = useStyles();
      const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;
      
      
  
      
    
   const saveDestination = async () =>{
    const destination={email, name, location,imageURL, pricePerNight}
    DestinationService.saveDestination({destination}).then(res=>{
      navigate('/') 
    })
  }
  
  
    return (
      
      <Container>
          <Paper elevation={3} style={paperStyle}>
              <h1 style={{color:"blue"}}><u>Create new destination</u></h1>
      <form className={classes.root} noValidate autoComplete="off">
      <TextField name='locationName'id="outlined-basic" label="Name" variant="outlined" fullWidth
        value={name}
        onChange={(e)=>setName(e.target.value)}
        />
         <TextField name='location'id="outlined-basic" label="Location" variant="outlined" fullWidth
        value={location}
        onChange={(e)=>setLocation(e.target.value)}
        />
        <TextField name='image-url'id="outlined-basic" label="Image URL" variant="outlined" fullWidth
        value={imageURL}
        onChange={(e)=>setImageURL(e.target.value)}
        />
         <TextField name='pricePerNight'id="outlined-basic" label="Price per night" variant="outlined" fullWidth
        value={pricePerNight}
        onChange={(e)=>setPricePerNight(e.target.value)}
        />
        
         <Button variant="contained" color="secondary" onClick={saveDestination}>
   Create Destination
  </Button>
      </form>
      
      </Paper>
      </Container>
      
    );
  }