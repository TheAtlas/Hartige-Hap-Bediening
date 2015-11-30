package edu.avans.hartigehap.bediening.model;

import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by rubie_000 on 30-11-2015.
 */
public class DetailOrderTableModel extends DefaultTableModel {



    private ArrayList<OrderDetail> orderItems;

    public DetailOrderTableModel(ArrayList<OrderDetail> orderItems)
    {
        this.orderItems = orderItems;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Object[][] data = new Object[orderItems.size()][5];
        String[] columns = new String[]
                {
                        "Naam", "EmployeeId", "Aantal","Prijs","Beschrijving", "Status"
                };
        for (int i = 0; i < orderItems.size(); i++)
        {
            OrderDetail orderItem = orderItems.get(i);
            data[i] = new Object[]
                    {
                            orderItem.getItemName(), orderItem.getEmployeeId(),orderItem.getAmount(),orderItem.getTotalPrice(),orderItem.getDescription(), orderItem.getStatus()
                    };
        }
        this.setDataVector(data, columns);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}
