package Daofab.Daofab.controller;

public class Parent {
    private int id;
    private String sender;
    private String receiver;
    private long totalAmount;
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Parent(int id, String sender, String receiver, long totalAmount) {
		super();
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.totalAmount = totalAmount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(long totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", totalAmount=" + totalAmount
				+ "]";
	}

    // Getters and setters
}