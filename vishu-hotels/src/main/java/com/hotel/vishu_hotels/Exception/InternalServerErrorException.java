package com.hotel.vishu_hotels.Exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String msg){
        super(msg);
    }
}
