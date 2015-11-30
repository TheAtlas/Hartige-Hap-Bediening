package edu.avans.hartigehap.bediening.model;

import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

/**
 * Created by rubie_000 on 29-11-2015.
 */
public class OrderTableModel extends DefaultTableModel {

    private Order order;
        public OrderTableModel(Order order)
        {
            this.order = order;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            Object[][] data = new Object[1][5];
            String[] columns = new String[]
                    {
                            "TafelNummer", "Gastnaam", "Totale prijs", "Datum","Status"
                    };

               data[0] = new Object[]
                        {
                                order.getTableNumber(), order.getGuestId(), order.getTotalAmount(),order.getDate(),order.getPaymentStatus()
                        };
            this.setDataVector(data, columns);
            }




    @Override
        public boolean isCellEditable(int row, int column)
        {
            return false;
        }

}
