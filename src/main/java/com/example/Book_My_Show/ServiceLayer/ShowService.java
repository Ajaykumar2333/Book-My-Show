package com.example.Book_My_Show.ServiceLayer;

import com.example.Book_My_Show.DTO.ShowDto;
import com.example.Book_My_Show.Models.*;
import com.example.Book_My_Show.Repository.MovieRepo;
import com.example.Book_My_Show.Repository.ShowRepo;
import com.example.Book_My_Show.Repository.ShowSeatRepo;
import com.example.Book_My_Show.Repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepo movieRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    ShowSeatRepo showSeatRepo;

    @Autowired
    ShowRepo showRepo;

    public  String addShow(ShowDto showDto){

        ShowEntity show = ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime()).multiplier(showDto.getMultiplier()).build();
        //you need to get the movie repo
        MovieEntity movie = movieRepo.findById(showDto.getMovieId()).get();

        TheatreEntity theatre = theatreRepo.findById(showDto.getTheatreId()).get();

        show.setTheatre(theatre);
        show.setMovie(movie);


//        List<ShowEntity> currentListOfShows = movie.getListOfShows();
//        currentListOfShows.add(show);
//        movie.setListOfShows(currentListOfShows); //like this also we can do

        //because we are doing a bidirectional mapping
        //Optional things it is not that much mandatory
        movie.getListOfShows().add(show);
        theatre.getListofShows().add(show);

//        theatreRepo.save(theatre);
        List<ShowSeatEntity> showSeatEntities = createShowSeats(theatre.getTheatreSeatEntities());



        show.setShowSeatEntities(showSeatEntities);


        //for each student we need to mark that to which show belongs(Foreign Key Will be Filled)
        for(ShowSeatEntity showSeat: showSeatEntities){
            showSeat.setShow(show);
        }
//        movieRepo.save(movie);

        movieRepo.save(movie);
        theatreRepo.save(theatre);
//        showRepo.save(show);  :this doesnot need to nbe called bcz parent save foreign is being called

        return "Show Added Succesfully";
    }
    public List<ShowSeatEntity> createShowSeats(List<TheatreSeatEntity> theatreSeatEntities){

        List<ShowSeatEntity> showSeatEntityList = new ArrayList<>();

        for(TheatreSeatEntity theatreSeats : theatreSeatEntities){
            ShowSeatEntity showSeat = ShowSeatEntity.builder().seatNo(theatreSeats.getSeatNo()).seatType(theatreSeats.getSeatType()).build();
            showSeatEntityList.add(showSeat);
        }
        showSeatRepo.saveAll(showSeatEntityList);

        return showSeatEntityList;

    }

}
