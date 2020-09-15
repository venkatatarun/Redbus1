package com.dto;

import java.sql.Timestamp;

public class Passenger_details {
private int id;
Passenger passenger_id;
Distance distance_id;
private int quantity;
private int total_amount;
private Timestamp order_date;

public Passenger_details() {
	super();
}

public Passenger_details(int id, Passenger passenger_id, Distance distance_id, int quantity, int total_amount,
		Timestamp order_date) {
	super();
	this.id = id;
	this.passenger_id = passenger_id;
	this.distance_id = distance_id;
	this.quantity = quantity;
	this.total_amount = total_amount;
	this.order_date = order_date;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Passenger getPassenger_id() {
	return passenger_id;
}

public void setPassenger_id(Passenger passenger_id) {
	this.passenger_id = passenger_id;
}

public Distance getDistance_id() {
	return distance_id;
}

public void setDistance_id(Distance distance_id) {
	this.distance_id = distance_id;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getTotal_amount() {
	return total_amount;
}

public void setTotal_amount(int total_amount) {
	this.total_amount = total_amount;
}

public Timestamp getOrder_date() {
	return order_date;
}

public void setOrder_date(Timestamp order_date) {
	this.order_date = order_date;
}

@Override
public String toString() {
	return "Passenger_details [id=" + id + ", passenger_id=" + passenger_id + ", distance_id=" + distance_id
			+ ", quantity=" + quantity + ", total_amount=" + total_amount + ", order_date=" + order_date + "]";
}





}
