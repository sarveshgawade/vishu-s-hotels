package com.hotel.vishu_hotels.Service;

import com.hotel.vishu_hotels.DTO.Hotel.CreateHotelRequestDTO;
import com.hotel.vishu_hotels.Entity.Hotel;

public interface HotelService {
    Hotel createHotel(CreateHotelRequestDTO hotel);
}
