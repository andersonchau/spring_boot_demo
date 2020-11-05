package com.and.demo.webappall.swagger.dto;

import java.util.List;

public class RegistrationRequest {
    private String memberId;
    private String hkID;
    private List<RegInfo> regInfoList;


    public static class RegInfo {
        String bookingTime;
        int ticketId;

        public String getBookingTime() {
            return bookingTime;
        }

        public void setBookingTime(String bookingTime) {
            this.bookingTime = bookingTime;
        }

        public int getTicketId() {
            return ticketId;
        }

        public void setTicketId(int ticketId) {
            this.ticketId = ticketId;
        }
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHkID() {
        return hkID;
    }

    public void setHkID(String hkID) {
        this.hkID = hkID;
    }

    public List<RegInfo> getRegInfoList() {
        return regInfoList;
    }

    public void setRegInfoList(List<RegInfo> regInfoList) {
        this.regInfoList = regInfoList;
    }
}
