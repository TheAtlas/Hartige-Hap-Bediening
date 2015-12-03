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
package edu.avans.hartigehap.bediening.io;

import edu.avans.hartigehap.bediening.model.Order;
import edu.avans.hartigehap.bediening.model.OrderDetail;
import edu.avans.hartigehap.bediening.model.OrderStatus;
import edu.avans.hartigehap.bediening.model.PaymentStatus;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author David
 */
public class OrderDAO {

    public Order getOrderByTableNumber(int tableNumber) {
        Order order = null;
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.open()) {

            try {
                PreparedStatement statement = connection.createStatement("SELECT * FROM dhh_order where TABLEtableNo = ? and paymentStatus = ?");
                statement.setInt(1, tableNumber);
                statement.setString(2, "NOT_PAID");

                ResultSet resultSet = connection.execute(statement);
                if (resultSet != null) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("orderNo");
                        String paymentStatus = resultSet.getString("paymentStatus");
                        int tableNo = resultSet.getInt("TABLEtableNo");
                        Date date = resultSet.getDate("orderDatetime");

                        Date dt = new java.util.Date();

                        java.text.SimpleDateFormat sdf =
                                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        String currentTime = sdf.format(date);

                        Order newOrder = new Order(id, 1, PaymentStatus.valueOf("NOT_PAID"), currentTime, 20.00, tableNo);
                        order = newOrder;
                        PreparedStatement subStament = connection.createStatement("select dhh_orderitem.*, dhh_item.Price*dhh_orderitem.amount as Itemtotalprice , dhh_beverage.alcoholPercentage from dhh_orderitem, dhh_item, dhh_beverage where ORDERorderNo = ? and dhh_orderitem.ITEMitemName = dhh_item.itemName and dhh_item.itemName = dhh_beverage.ITEMitemName");
                        subStament.setInt(1, order.getId());
                        ResultSet subResultSet = connection.execute(subStament);

                        if (subResultSet != null) {
                            while (subResultSet.next()) {
                                OrderDetail orderDetails = new OrderDetail(subResultSet.getInt("ORDERorderNo"), OrderStatus.values()[subResultSet.getInt("orderStatus")-1], subResultSet.getInt("EMPLOYEEemployeeid"), subResultSet.getInt("amount"), subResultSet.getString("description"), subResultSet.getString("ITEMitemName"), subResultSet.getDouble("Itemtotalprice"));
                                order.addOrderDetail(orderDetails);
                            }
                        }
                    }


                }
            } catch (SQLException e) {

                e.printStackTrace();
            }


            connection.close();
        }

        return order;
    }

    public void changeStatusById(int orderId, int newStatus,String itemName) {
        System.out.println(orderId + "orderstatus = " +   newStatus + itemName);
        DatabaseConnection connection = new DatabaseConnection();
        if (connection.open()) {

            try {
                PreparedStatement statement = connection.createStatement("UPDATE dhh_orderitem set orderStatus = ? where ORDERorderNo = ? and ITEMitemName = ?");
                statement.setInt(1,newStatus);
                statement.setInt(2,orderId);
                statement.setString(3,itemName);
                statement.execute();
            }
            catch (SQLException e) {

                e.printStackTrace();
            }


            connection.close();
        }


    }
}
