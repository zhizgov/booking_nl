import jwtDecode from "jwt-decode";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import UserService from "../functions/UserService";
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';
import DestinationService from "../functions/DestinationService";
import { toast } from "react-toastify";

export default function Profile() {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const email = jwtDecode(sessionStorage.getItem("accessToken")).sub;
    const [firstName, setFName]=useState('');
    const [lastName, setLName]=useState('');
    const [adress, setAddress]=useState('');
    const role = sessionStorage.getItem("role");

    const updateUserDetails=()=>{
      const userRequest={email, firstName, lastName, adress}
    UserService.updateUserDetails({userRequest})
    toast.success("Successfull update!")
    }

      const getUser = () =>
        UserService.getUser(email);

        
      
        
  useEffect(()=>{
   
    if (role !== "[Admin]" && role !== "[Customer]" ) {
    navigate("/");
     
    }
    
      getUser().then(res => {
        console.log(res.data);
        setUser(res.data)
        setFName(res.data.firstName)
setLName(res.data.lastName)
        setAddress(res.data.adress)
      })
  },[])

 

 

  return (
    
    <div className="userInfo" >
      {user &&
        <div key={user.id}>
    <TextField name="fNameProfile" id="outlined-basic" label="First Name" variant="outlined" fullWidth
      value={firstName}
      onChange={(e)=>setFName(e.target.value)}
      />
      <TextField name="lNameProfile" id="outlined-basic2" label="Last Name" variant="outlined" fullWidth
      value={lastName}
      onChange={(e)=>setLName(e.target.value)}
      />
      <TextField name="adressProfile" id="outlined-basic3" label="Address" variant="outlined" fullWidth
      value={adress}
      onChange={(e)=>setAddress(e.target.value)}
      />
<Button variant="contained" color="secondary" onClick={updateUserDetails}>
 Update
</Button>
         
        </div>
      }
    </div>
  );

}