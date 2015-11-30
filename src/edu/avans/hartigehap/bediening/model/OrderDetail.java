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

/**
 *
 * @author David Verhaak
 * @version 1.0.0
 */
public class OrderDetail
{

//	private int id;
	private int orderId;
	private String description;
	private OrderStatus status;
	private String itemName;
	private int employeeId;
	private int amount;
	private double totalPrice;
	private int consumableId;

	public OrderDetail(int orderId, OrderStatus status, int employeeId, int amount,String description,String itemName,Double totalPrice)
	{
//		this.id = id;
		this.description = description;
		this.orderId = orderId;
		this.status = status;
		this.employeeId = employeeId;
		this.amount = amount;
		this.itemName = itemName;
		this.totalPrice = totalPrice;
//		this.consumableId = consumableId;
	}

//	public int getId()
//	{
//		return id;
//	}
//
//	public void setId(int id)
//	{
//		this.id = id;
//	}

	public int getOrderId()
	{
		return orderId;
	}

	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}

	public OrderStatus getStatus()
	{
		return status;
	}

	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}

	public int getEmployeeId()
	{
		return employeeId;
	}

	public void setEmployeeId(int employeeId)
	{
		this.employeeId = employeeId;
	}

	public int getAmount()
	{
		return amount;
	}

	public void setAmount(int amount)
	{
		this.amount = amount;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public int getConsumableId()
	{
		return consumableId;
	}

	public void setConsumableId(int consumableId)
	{
		this.consumableId = consumableId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
