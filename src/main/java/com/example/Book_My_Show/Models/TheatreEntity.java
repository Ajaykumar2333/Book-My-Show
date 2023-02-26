package com.example.Book_My_Show.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name =  "theatre")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String name;
    private String address;

    //List Of shows

    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    List<TheatreSeatEntity> theatreSeatEntities;



    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<ShowEntity> listofShows;
}
