package com.hotel.vishu_hotels.DTO.Hotel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreateHotelRequestDTO {
        @NotBlank(message = "Hotel Name is a required field")
        private String hotelName;

        @NotBlank(message = "Owner Name is a required field")
        private String ownerName;

        @NotBlank(message = "Email is a required field")
        @Email(message = "Invalid Email format")
        private String email;

        @NotBlank(message = "Contact Number is a required field")
        private String contactNumber;

        @NotBlank(message = "Address is a required field")
        private String address;
}
