import React, { PureComponent } from 'react';
import { useState, useEffect } from 'react';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';
import DestinationService from '../functions/DestinationService';



export default function Statistics () {
    
    const [data, setData] = useState([]);

    const getStatistics = () =>
            DestinationService.getTopVisits();
    
            useEffect(()=>{
                  getStatistics().then(res => {
                    console.log(res.data)
                    setData(res.data)
                    
                  })
              },[])
  
    return (
      <ResponsiveContainer width="100%" height="100%">
        <BarChart width={150} height={40} data={data}>
          <Bar dataKey="visit" fill="#8884d8" />
        </BarChart>
      </ResponsiveContainer>
    );
  }

