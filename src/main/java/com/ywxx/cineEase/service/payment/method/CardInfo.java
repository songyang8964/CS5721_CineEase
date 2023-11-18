package com.ywxx.cineEase.service.payment.method;

public class CardInfo {
        private Long id;
        private String holderName;
        private String signature;
        private String address;
        private String email;
        private String phone;

        public CardInfo() {

        }

        public CardInfo(Long id, String holderName, String signature, String address, String email, String phone) {
            this.id = id;
            this.holderName = holderName;
            this.signature = signature;
            this.address = address;
            this.email = email;
            this.phone = phone;
        }
}
