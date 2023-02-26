package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepo extends JpaRepository<ShowEntity,Integer> {

}
