package com.example.Book_My_Show.ServiceLayer;

import com.example.Book_My_Show.DTO.TheatreDto;
import com.example.Book_My_Show.Enum.SeatType;
import com.example.Book_My_Show.Models.TheatreEntity;
import com.example.Book_My_Show.Models.TheatreSeatEntity;
import com.example.Book_My_Show.Repository.TheatreRepo;
import com.example.Book_My_Show.Repository.TheatreSeatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheatreService {

    @Autowired
    TheatreRepo theatreRepo;
    @Autowired
    TheatreSeatsRepo theatreSeatsRepo;

    public  String addTheatre(TheatreDto theatreDto) {

        TheatreEntity theatre = TheatreEntity.builder().name(theatreDto.getName()).city(theatreDto.getCity()).address(theatreDto.getAddress()).build();

        List<TheatreSeatEntity> seats = createTheatreSeatEntities();
        theatre.setTheatreSeatEntities(seats);
        for (TheatreSeatEntity theatreSeats : seats){
            theatreSeats.setTheatreEntity(theatre);
        }
        theatreRepo.save(theatre);


        return "Theatre Added Succesfully";



    }

    public List<TheatreSeatEntity> createTheatreSeatEntities(){

        List<TheatreSeatEntity> listOfTheatres  = new ArrayList<>();
        TheatreSeatEntity theatreSeat1 = new TheatreSeatEntity("1A",SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeat2 = new TheatreSeatEntity("2A",SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeat3 = new TheatreSeatEntity("3A",SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeat4  = new TheatreSeatEntity("4A",SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeat5 = new TheatreSeatEntity("5A",SeatType.CLASSIC,100);
        TheatreSeatEntity theatreSeat6 = new TheatreSeatEntity("1B",SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeat7 = new TheatreSeatEntity("2B",SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeat8 = new TheatreSeatEntity("3B",SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeat9  = new TheatreSeatEntity("4B",SeatType.PLATINUM,100);
        TheatreSeatEntity theatreSeat10 = new TheatreSeatEntity("5B",SeatType.PLATINUM,100);

        listOfTheatres.add(theatreSeat1);
        listOfTheatres.add(theatreSeat2);
        listOfTheatres.add(theatreSeat3);
        listOfTheatres.add(theatreSeat4);
        listOfTheatres.add(theatreSeat5);
        listOfTheatres.add(theatreSeat6);
        listOfTheatres.add(theatreSeat7);
        listOfTheatres.add(theatreSeat8);
        listOfTheatres.add(theatreSeat9);
        listOfTheatres.add(theatreSeat10);
        theatreSeatsRepo.saveAll(listOfTheatres);

        return listOfTheatres;
    }
}
