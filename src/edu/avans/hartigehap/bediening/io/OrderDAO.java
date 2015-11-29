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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class OrderDAO
{

    public Order getOrderByTableNumber(int tableNumber){
        Order order = null;
    DatabaseConnection connection = new DatabaseConnection();
        if(connection.open()){

            try{
                PreparedStatement statement = connection.createStatement("SELECT * FROM dhh_order where TABLEtableNo = ? and paymentStatus = ?");
                statement.setInt(1, tableNumber);
                statement.setString(2,"Unpayed");

                ResultSet resultSet = connection.execute(statement);
                if(resultSet != null){
                    while(resultSet.next()){
                        int id = resultSet.getInt("orderNo");
                        String paymentStatus = resultSet.getString("paymentStatus");
                        int tableNo = resultSet.getInt("TABLEtableNo");

                         Order newOrder = new Order(id,1,null,"19-20-2010","9 uur",20.00,tableNo);
                        order = newOrder;
                    }


                }
            }
            catch(SQLException e) {

                e.printStackTrace();
            }



            connection.close();
        }

    return order;
    }

}
