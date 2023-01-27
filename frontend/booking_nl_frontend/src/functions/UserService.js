import axios from "axios";
import { useNavigate } from "react-router-dom";
import { toast } from 'react-toastify';

const userURL = 'http://localhost:8080/api';
const jwtToken = sessionStorage.getItem("accessToken");
const refreshToken = sessionStorage.getItem("refreshToken");

const register =  (user) => {
 
  return new Promise( (resolve, reject) => {
       axios.post(`${userURL}/register`, user.user, {
      }).then(response => {
          console.log('kur', response.data);
          resolve(response.data);
          //navigate('/login')
  
      }).catch((err) => {
  
          if (err.response.status === 500) {
  
              reject(toast.error("Email taken or wrong information entered! Please try again later!"));
  
  
          }
          else {
            reject({err});

          }
      });
  })
  }

// const refresh=()=>{
//   axios.post(`${userURL}/token/refresh`, {
//     headers:{
//         'Authorization':"Bearer " + refreshToken
//     }
// })}

const logout = () => {
   sessionStorage.clear();
   window.location.reload();
}

const getUser = (email) =>{
  return axios.post(`${userURL}`, email, {
    params:{
'email': email
    },
    headers:{
        'Authorization':"Bearer " + jwtToken
    }
})
}

const updateUserDetails = (userRequest) =>{
  return axios.put(`${userURL}`, userRequest.userRequest, {
    headers:{
        'Authorization':"Bearer " + jwtToken
    }
}).then(response => {
  toast.success("Succesful update of your profile details!")

})
}


export default  {
 register,
 logout, 
 getUser,
 updateUserDetails
}
