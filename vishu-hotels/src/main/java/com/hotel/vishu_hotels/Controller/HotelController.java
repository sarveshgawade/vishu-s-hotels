package com.hotel.vishu_hotels.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.vishu_hotels.DTO.StandardResponse;
import com.hotel.vishu_hotels.Entity.Hotel;
import com.hotel.vishu_hotels.Repository.HotelRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/vishu-hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository ;

    @PostMapping()
    public ResponseEntity<StandardResponse<Hotel>> createHotel(@Valid @RequestBody Hotel hotel) {
        Hotel savedHotel =  hotelRepository.save(hotel);

        StandardResponse<Hotel> response = new StandardResponse<>(
            savedHotel,
            HttpStatus.CREATED.value(),
            "Hotel created successfully !",
            true
        ) ;

        return new ResponseEntity<>(response,HttpStatus.CREATED) ;
    }

    @GetMapping()
    public ResponseEntity<StandardResponse<List<Hotel> >> getHotels() {
        List<Hotel> hotelList =  hotelRepository.findAll();

        StandardResponse<List<Hotel>> response = new StandardResponse<>(
            hotelList,
            HttpStatus.OK.value(),
            "Hotels fetched successfully",
            true
        ) ;

        return new ResponseEntity<>(response,HttpStatus.OK) ;
    }
    
    
}
