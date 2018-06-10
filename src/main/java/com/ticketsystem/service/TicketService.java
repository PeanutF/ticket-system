package com.ticketsystem.service;

import com.ticketsystem.dao.TicketMapper;
import com.ticketsystem.model.Ticket;
import com.ticketsystem.model.TicketExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    public List<Ticket> getAllTicket(){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria();
        return ticketMapper.selectByExample(ticketExample);
    }

    public List<Ticket> getTicketByFormId(int id){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andOrderFormIdEqualTo(id);
        return ticketMapper.selectByExample(ticketExample);
    }

    public Ticket getTicketById(int ticketId){
        return ticketMapper.selectByPrimaryKey(ticketId);
    }

    public void altTicket(int ticketId, int flightId, String passengerName, float price){
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setFlightId(flightId);
        ticket.setPassengerName(passengerName);
        ticket.setTicketId(ticketId);
        ticketMapper.updateByPrimaryKeySelective(ticket);
    }

}
