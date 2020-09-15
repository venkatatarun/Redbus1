package com.dto;

public class Paymentdto {
	private int payment_id;
	User user_id;
	Ticketdto ticket_id;
	private String from;
	private String to;
	private int totalprice;
	public Paymentdto() {
		super();
	}
	public Paymentdto(int payment_id, User user_id, Ticketdto ticket_id, String from, String to, int totalprice) {
		super();
		this.payment_id = payment_id;
		this.user_id = user_id;
		this.ticket_id = ticket_id;
		this.from = from;
		this.to = to;
		this.totalprice = totalprice;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	public Ticketdto getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Ticketdto ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "Paymentdto [payment_id=" + payment_id + ", user_id=" + user_id + ", ticket_id=" + ticket_id + ", from="
				+ from + ", to=" + to + ", totalprice=" + totalprice + "]";
	}
	
	

}
