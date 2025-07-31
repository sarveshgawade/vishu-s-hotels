package com.hotel.vishu_hotels.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.vishu_hotels.DTO.Hotel.CreateHotelRequestDTO;
import com.hotel.vishu_hotels.Entity.Hotel;

public interface HotelRepository  extends JpaRepository<Hotel,Long>{

    Hotel save(CreateHotelRequestDTO hotel);
    boolean existsByEmail(String email) ;

}
