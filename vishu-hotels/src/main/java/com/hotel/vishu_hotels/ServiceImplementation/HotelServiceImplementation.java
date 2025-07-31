package com.hotel.vishu_hotels.ServiceImplementation;

import org.springframework.stereotype.Service;

import com.hotel.vishu_hotels.DTO.Hotel.CreateHotelRequestDTO;
import com.hotel.vishu_hotels.Entity.Hotel;
import com.hotel.vishu_hotels.Repository.HotelRepository;
import com.hotel.vishu_hotels.Service.HotelService;

@Service
public class HotelServiceImplementation  implements HotelService {

    private final  HotelRepository hotelRepository;

    public HotelServiceImplementation(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository ;
    }

    @Override
    public Hotel createHotel(CreateHotelRequestDTO hotel) {

        if(hotelRepository.existsByEmail(hotel.getEmail())){
            throw new RuntimeException("Hotel with this email already exists") ;
        }

        Hotel newHotel = new Hotel() ;

        newHotel.setHotelName(hotel.getHotelName());
        newHotel.setOwnerName(hotel.getOwnerName());
        newHotel.setEmail(hotel.getEmail());
        newHotel.setContactNumber(hotel.getContactNumber());
        newHotel.setAddress(hotel.getAddress());

        return hotelRepository.save(newHotel);
    }

}
