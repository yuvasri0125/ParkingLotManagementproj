package com.wipro.parking.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.wipro.parking.bean.ParkingBean;
import com.wipro.parking.service.Administrator;

public class MainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        Administrator admin = new Administrator();

        try {

            // ================= ADD RECORD =================
            if ("newRecord".equals(operation)) {

                ParkingBean bean = new ParkingBean();

                bean.setVehicleNumber(request.getParameter("vehicleNumber"));
                bean.setSlotNumber(request.getParameter("slotNumber"));

                String dateStr = request.getParameter("entryDateTime");
                Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(dateStr);
                bean.setEntryDateTime(date);

                bean.setCharges(Integer.parseInt(request.getParameter("charges")));
                bean.setRemarks(request.getParameter("remarks"));

                String result = admin.addRecord(bean);

                if ("FAIL".equals(result))
                    response.sendRedirect("error.html");
                else
                    response.sendRedirect("success.html");
            }

            // ================= VIEW SINGLE RECORD =================
            else if ("viewRecord".equals(operation)) {

                String vehicleNumber = request.getParameter("vehicleNumber");

                String dateStr = request.getParameter("entryDateTime");
                Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(dateStr);

                ParkingBean bean = admin.viewRecord(vehicleNumber, date);

                request.setAttribute("parkingBean", bean);
                RequestDispatcher rd = request.getRequestDispatcher("displayParking.jsp");
                rd.forward(request, response);
            }

            // ================= VIEW ALL RECORDS =================
            else if ("viewAllRecords".equals(operation)) {

                List<ParkingBean> list = admin.viewAllRecords();

                request.setAttribute("parkingList", list);
                RequestDispatcher rd = request.getRequestDispatcher("displayAllParking.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();   // VERY IMPORTANT
            response.sendRedirect("error.html");
        }
    }
}
