package com.wipro.parking.bean;

import java.util.Date;

public class ParkingBean {

    private String recordId;
    private String vehicleNumber;
    private String slotNumber;
    private Date entryDateTime;
    private Date exitDateTime;
    private int charges;
    private String remarks;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Date getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(Date entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public Date getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(Date exitDateTime) {
        this.exitDateTime = exitDateTime;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
