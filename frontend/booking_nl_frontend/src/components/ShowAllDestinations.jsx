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



export  function ShowAllDestinations  ()  {
   const [destinations, setDestinations] = useState([]);
   const [searchedDestination, setSearchedDestinations] = useState('');
  
   
function handleSearch(e){
  setSearchedDestinations(e.target.value);
}



   const searchDestination=destinations.filter((destination) =>
   destination.name.toLowerCase().includes(searchedDestination.toLowerCase()))

   useEffect(()=>{
    DestinationService.getAllDestinations().then(res => setDestinations(res.data));
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
  test:{
    fontSize: "80px"
  }

}));   
 return ( 
  
   <div  className="singleDestination">
     <input className='searchbar'
 type="text"
 placeholder="Search by destination name"
 onChange={handleSearch}/> 
 <div className='card-container'>

 
  {searchDestination.map((destination) => (
  

       <div key={destination.id} className = 'card'>
   
    <h2 className="card-name">{destination.name}</h2>
    <p className="card-location">{destination.location}</p>
    <p className="card-price">${destination.pricePerNight}/ night </p>
    <button  className="card-button"><Link to={`/singleDestination/${destination.id}`}>Show</Link></button>
</div>
    

    ))}
    </div>
    </div>
 );


  }


    

