import axios, { AxiosHeaders } from "axios";
import { toast } from "react-toastify";


const destinationsURL = 'http://localhost:8080/destinations';
const jwtToken = window.sessionStorage.getItem('accessToken');


const getAllDestinations = async () => {
    try {
          return await axios.get(`${destinationsURL}`);
    } catch (error) {
        console.log('Error with idk', error);
    }
}

const saveDestination = (destination) => {
    
    console.log(destination)
     return axios.post(`${destinationsURL}/create`, destination.destination,{
        headers:{
            'Authorization': "Bearer " + jwtToken
        }
     }).then(response=>{
        toast.success("Destination successfuly created!")

     }).catch((err) => {

        if (err.response.status === 403) {
  
          toast.error("There is already a destination with the same name and location!");
  
        }else{

            throw new Error();
    
          }
    })
     ;
}


const deleteDestination = (id, email) => {
    return axios.delete(`${destinationsURL}/${id}`, {data:email}, {
        headers:{
            'Authorization':"Bearer " + jwtToken
        }
    }).then(response=>{
        console.log('kur',response.data)
toast.success('Successfull deletion of the destination!');
window.location.reload();
    });
}

const getDestination = (id) =>{
    return axios.get(`${destinationsURL}/${id}`)
}

const visitDestination = (visit) => {
    
     return axios.post(`${destinationsURL}/visit`, visit).then(response=>{
        console.log(visit);
     })
     ;}

     const getTopVisits = async () => {
        try {
              return await axios.get(`${destinationsURL}/statistics`);
        } catch (error) {
            console.log('Error with idk', error);
        }
    }
export default  {
    getAllDestinations,
    deleteDestination,
    saveDestination,
    getDestination,
    visitDestination,
    getTopVisits
}
