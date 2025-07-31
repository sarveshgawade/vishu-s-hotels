    package com.hotel.vishu_hotels.Entity;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;

    @Entity
    public class Hotel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @NotBlank(message = "Hotel Name is a required field")
        private String hotelName;

        @NotBlank(message = "Owner Name is a required field")
        private String ownerName;

        @NotBlank(message = "Email is a required field")
        @Column(unique = true)
        @Email(message = "Invalid Email format")
        private String email;

        @NotBlank(message = "Contact Number is a required field")
        private String contactNumber;

        @NotBlank(message = "Address is a required field")
        private String address;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }
