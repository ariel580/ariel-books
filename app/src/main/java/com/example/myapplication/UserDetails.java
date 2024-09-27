package com.example.myapplication;

public class UserDetails {
        private String name;
        private String email;
        private String password;
        private String password2;
        private String phone;

        public UserDetails() {

        }
        public UserDetails(String name, String email, String password, String password2, String phone) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.password2 = password2;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword2() {
            return password2;
        }

        public void setPassword2(String password2) {
            this.password2 = password2;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }



