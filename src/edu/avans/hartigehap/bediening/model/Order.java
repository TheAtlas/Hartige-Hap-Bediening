/*
 * Copyright (C) 2015, David Verhaak
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.avans.hartigehap.bediening.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author David Verhaak
 * @version 1.0.0
 */
public class Order {

    private int id;
    private int guestId;
    private PaymentStatus paymentStatus;
    //	private String date;
//	private String time;
    private String date;
    private double totalAmount;
    private int tableNumber;
    private ArrayList<OrderDetail> orderDetails;


    public Order(int id, int guestId, PaymentStatus paymentStatus, String date, double totalAmount, int tableNumber) {
        this.id = id;
        this.guestId = guestId;
        this.paymentStatus = paymentStatus;
        this.date = date;
//		this.time = time;
        this.totalAmount = totalAmount;
        this.tableNumber = tableNumber;
        orderDetails = new ArrayList<>();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

//	public String getDate()
//	{
//		return date;
//	}
//
//	public void setDate(String date)
//	{
//		this.date = date;
//	}

    //	public String getTime()
//	{
//		return time;
//	}
//
//	public void setTime(String time)
//	{
//		this.time = time;
//	}
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        orderDetails.clear();
        orderDetails.addAll(orderDetails);
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }
}
