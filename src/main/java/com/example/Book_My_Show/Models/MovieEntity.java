package com.example.Book_My_Show.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private  int id;


    @Column(nullable = false,unique = true)
    private String  movieName;

    private  String duration;

    private Date releaseDate;


    @OneToMany(mappedBy = "movie",  cascade = CascadeType.ALL)
    private  List<ShowEntity> listOfShows;






}
