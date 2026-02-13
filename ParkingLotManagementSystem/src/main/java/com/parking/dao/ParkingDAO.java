package com.parking.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.wipro.parking.bean.ParkingBean;
import com.wipro.parking.util.DBUtil;

public class ParkingDAO {

    public String generateRecordID(String vehicleNumber, java.util.Date entryDateTime) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String datePart = format.format(entryDateTime);

        String prefix = vehicleNumber.substring(0, 2).toUpperCase();

        Connection con = DBUtil.getDBConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT PARKING_SEQ.NEXTVAL FROM DUAL");

        rs.next();
        int seq = rs.getInt(1);

        rs.close();
        st.close();
        con.close();

        return datePart + prefix + seq;
    }

    public boolean recordExists(String vehicleNumber, java.util.Date entryDateTime) throws Exception {

        Connection con = DBUtil.getDBConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM PARKING_TB WHERE VEHICLENUMBER=? AND ENTRY_DATETIME=?");

        ps.setString(1, vehicleNumber);
        ps.setTimestamp(2, new Timestamp(entryDateTime.getTime()));

        ResultSet rs = ps.executeQuery();

        boolean exists = rs.next();

        rs.close();
        ps.close();
        con.close();

        return exists;
    }

    public String createRecord(ParkingBean bean) throws Exception {

        Connection con = DBUtil.getDBConnection();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO PARKING_TB VALUES(?,?,?,?,?,?,?)");

        ps.setString(1, bean.getRecordId());
        ps.setString(2, bean.getVehicleNumber());
        ps.setString(3, bean.getSlotNumber());
        ps.setTimestamp(4, new Timestamp(bean.getEntryDateTime().getTime()));
        ps.setTimestamp(5, null);
        ps.setInt(6, bean.getCharges());
        ps.setString(7, bean.getRemarks());

        int result = ps.executeUpdate();

        ps.close();
        con.close();

        if (result > 0)
            return bean.getRecordId();
        else
            return "FAIL";
    }

    public ParkingBean fetchRecord(String vehicleNumber, java.util.Date entryDateTime) throws Exception {

        Connection con = DBUtil.getDBConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM PARKING_TB WHERE VEHICLENUMBER=? AND ENTRY_DATETIME=?");

        ps.setString(1, vehicleNumber);
        ps.setTimestamp(2, new Timestamp(entryDateTime.getTime()));

        ResultSet rs = ps.executeQuery();

        ParkingBean bean = null;

        if (rs.next()) {
            bean = new ParkingBean();
            bean.setRecordId(rs.getString(1));
            bean.setVehicleNumber(rs.getString(2));
            bean.setSlotNumber(rs.getString(3));
            bean.setEntryDateTime(rs.getTimestamp(4));
            bean.setCharges(rs.getInt(6));
            bean.setRemarks(rs.getString(7));
        }

        rs.close();
        ps.close();
        con.close();

        return bean;
    }

    public List<ParkingBean> fetchAllRecords() throws Exception {

        List<ParkingBean> list = new ArrayList<>();

        Connection con = DBUtil.getDBConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM PARKING_TB");

        while (rs.next()) {
            ParkingBean bean = new ParkingBean();
            bean.setRecordId(rs.getString(1));
            bean.setVehicleNumber(rs.getString(2));
            bean.setSlotNumber(rs.getString(3));
            bean.setEntryDateTime(rs.getTimestamp(4));
            bean.setCharges(rs.getInt(6));
            bean.setRemarks(rs.getString(7));
            list.add(bean);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }
}
