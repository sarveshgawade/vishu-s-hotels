package com.hotel.vishu_hotels.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.vishu_hotels.DTO.StandardResponse;
import com.hotel.vishu_hotels.DTO.Hotel.CreateHotelRequestDTO;
import com.hotel.vishu_hotels.Entity.Hotel;
import com.hotel.vishu_hotels.Service.HotelService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/vishu-hotels")
public class HotelController {

    private final HotelService hotelService;

    //used constructor injection 
    /*
     * Why Constructor Injection?
        Improves immutability—dependencies can’t be changed after creation.

        Makes your classes easier to test.

        Ensures all required dependencies are provided at object creation.

        Reveals dependency issues clearly at startup
     */
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService ;
    }

    @PostMapping()
    public ResponseEntity<StandardResponse<Hotel>> createHotel(@Valid @RequestBody CreateHotelRequestDTO hotel) {
        Hotel savedHotel =  hotelService.createHotel(hotel) ;

        StandardResponse<Hotel> response = new StandardResponse<>(
            savedHotel,
            HttpStatus.CREATED.value(),
            "Hotel created successfully !",
            true
        ) ;

        return new ResponseEntity<>(response,HttpStatus.CREATED) ;
    }
    
}
