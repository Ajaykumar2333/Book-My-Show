package com.example.Book_My_Show.ServiceLayer;

import com.example.Book_My_Show.DTO.TicketBookingDt;
import com.example.Book_My_Show.Models.ShowEntity;
import com.example.Book_My_Show.Models.ShowSeatEntity;
import com.example.Book_My_Show.Models.TicketEntity;
import com.example.Book_My_Show.Models.UserEntity;
import com.example.Book_My_Show.Repository.ShowRepo;
import com.example.Book_My_Show.Repository.TIcketRepo;
import com.example.Book_My_Show.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ShowRepo showRepo;
    @Autowired
    UserRepo userRepo;

    @Autowired
    TIcketRepo tIcketRepo;

    public String bookTicket(TicketBookingDt ticketBookingDt) throws Exception {
        List<String> requestedSeats = ticketBookingDt.getRequestedSeats();

        ShowEntity show = showRepo.findById(ticketBookingDt.getShowID()).get();

        UserEntity user = userRepo.findById(ticketBookingDt.getUserID()).get();

        List<ShowSeatEntity> showseats = show.getShowSeatEntities();

        List<ShowSeatEntity> bookedSeats = new ArrayList<>();

        for(ShowSeatEntity showSeat : showseats){
            String seatNo = showSeat.getSeatNo();

            if(showSeat.isBooked()== false && requestedSeats.contains(seatNo)){
                bookedSeats.add(showSeat);
            }
        }

        if(bookedSeats.size()!= requestedSeats.size()){
            //some seats that is user requested not available
            throw new  Exception("Request seats not available");
        }

        //this means the bookedseats actually contains the booked seats

        TicketEntity ticketEntity = new TicketEntity();
        double total = 0;
        double multiplier = show.getMultiplier();
        String allotedSeats = " ";

        int rate = 0;

        for (ShowSeatEntity bookedSeat : bookedSeats){
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setBooked(true);
            bookedSeat.setTicketEntity(ticketEntity);
            bookedSeat.setShow(show);

            String seatNo = bookedSeat.getSeatNo();
            allotedSeats = allotedSeats+seatNo;

            if(bookedSeat.getSeatNo().charAt(0) == '1'){
                rate = 100;
            }else {
                rate = 200;
            }
            total += multiplier * rate;


        }
        ticketEntity.setShow(show);
        ticketEntity.setBookedAt(new Date());
        ticketEntity.setAmount((int) total);
        ticketEntity.setUser(user);
        ticketEntity.setBookedSeats(bookedSeats);
        ticketEntity.setAlloted_seats(allotedSeats);

      //Bidirectional part is pending still
        tIcketRepo.save(ticketEntity);
        return "succesfully ticket is created";

    }
}
