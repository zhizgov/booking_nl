import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import { Link, useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import UserService from '../functions/UserService';
import saveDestination from '../functions/DestinationService'
import AccountCircleIcon from '@material-ui/icons/AccountCircle';
import jwtDecode from 'jwt-decode';

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  menuButton: {
    marginRight: theme.spacing(2),
  },
  title: {
    flexGrow: 1
  }
}));



export default function Appbar() {
  const classes = useStyles();
  const navigate = useNavigate();
//const [role, setRole] = useState('');
const [buttons, setButtons] = useState(null);

  useEffect(()=>{
    const role = sessionStorage.getItem("role");

    if (role === "[Admin]" ) {
     setButtons(<>
     <Button name='createDest' id='createDest'  color="white" > <Link to={'/createDestinations'}>Create Destinations</Link></Button>
     <Button  color="inherit" > <Link to={'/chat'}>Chat</Link></Button>
     <Button onClick={UserService.logout} color="inherit" > <Link to={'/'}>Log Out</Link></Button>
    
     </>);
     
    }
    else if (role === "[Customer]" ) {
      setButtons(<>
       
       <Button   color="inherit" > <Link to={'/chat'}>Chat</Link></Button>
       <Button  color="inherit" > <Link to={'/myReservations'}>My Reservations</Link></Button>
      <Button onClick={UserService.logout} color="inherit" > <Link to={'/'}>Log Out</Link></Button>
      <IconButton id='profiles' edge="start"  className={classes.menuButton} color="inherit" aria-label="menu">
          <Link to={'/profile'}>
            <AccountCircleIcon  />
            </Link>
          </IconButton>
      </>);
      
     }
    else{
      setButtons(<>
       <Button  color="white" > <Link to={'/login'}>Log in</Link></Button>
<Button> <Link color="white" to={'/register'}>Register</Link></Button>
        </>);

    }
   
  },[])



  return (
    <div className={classes.root}>
      <AppBar position="static">
        <Toolbar>
          
         
          <Typography variant="h6" className={classes.title}>
            Booking NL
          </Typography>
          <Button  color="inherit" > <Link to={'/'}>Home</Link></Button>
          
          {buttons} 

         
         

        </Toolbar>
      </AppBar>
    </div>
  );
}
