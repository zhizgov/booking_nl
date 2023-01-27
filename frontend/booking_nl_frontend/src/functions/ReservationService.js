import axios, { AxiosHeaders } from "axios";
import { toast } from "react-toastify";


const reservationURL = 'http://localhost:8080/reservations';
const jwtToken = sessionStorage.getItem('accessToken');

const makeReservation=(reservation)=>{
    return axios.post(`${reservationURL}`, reservation.reservation,{
        
        
        headers:{
            'Authorization': "Bearer " + jwtToken
        }
     }).then(response=>{
        toast.success("Reservation successfuly created!")

     }).catch((err) => {

        if (err.response.status === 403) {
  
          toast.error(err.response.message);
  
        }else if (err.response.status === 500) {
  
            toast.error(err.response.message);
    
          }
        else{

            toast.error(err.response.message);
    
          }
    })
     ;
}


const getReservations = (userId) =>{
    return axios.post(`${reservationURL}/private`, userId, {
        params:{
            'userId': userId
                },
      headers:{
          'Authorization':"Bearer " + jwtToken
      }
  });
  
  }
  
export default  {
    makeReservation,
    getReservations
}