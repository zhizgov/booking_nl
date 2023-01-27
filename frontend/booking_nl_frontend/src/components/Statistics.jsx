import React, { PureComponent } from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';
import DestinationService from '../functions/DestinationService';



export default function Statistics () {

    const [data,setData] = useState([]);

    const getTopStatistics = () =>
    DestinationService.getTopVisits()

        useEffect(()=>{
            getTopStatistics().then(res => {
              setData(res.data);
            });
            console.log(data);
        },[]);


        return (
            <ResponsiveContainer width="100%" height="100%">
              <BarChart
                width={500}
                height={300}
                data={data}

                margin={{
                  top: 5,
                  right: 30,
                  left: 20,
                  bottom: 5,
                }}
              >
                <CartesianGrid strokeDasharray="3 3" />
                <XAxis dataKey="visit" />
                <YAxis />
                <Tooltip />
                <Legend />
                <Bar dataKey="visit" name={"loggedd in users"} fill="#8884d8" />
                <Bar dataKey="count" fill="#82ca9d" />
              </BarChart>
            </ResponsiveContainer>
          );
        

    }
    
