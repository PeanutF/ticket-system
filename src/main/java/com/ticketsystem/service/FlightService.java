package com.ticketsystem.service;

import com.ticketsystem.dao.FlightMapper;
import com.ticketsystem.model.Flight;
import com.ticketsystem.model.FlightExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightMapper flightMapper;

    public List<Flight> getAllFlight(){
        return flightMapper.selectByExample(new FlightExample());
    }

    public Flight getFlightById(int flightId){
        return flightMapper.selectByPrimaryKey(flightId);
    }

    public void altFlight(Flight flight){
        flightMapper.updateByPrimaryKeySelective(flight);
    }
}
