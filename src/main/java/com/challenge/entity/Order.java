package com.challenge.entity;


public class Order {
	private Long epoch;
	public Long getEpoch() {
		return epoch;
	}
	public void setEpoch(Long epoch) {
		this.epoch = epoch;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");
		result.append(this.getName()).append(" ").append(this.getEpoch());
		
		return result.toString();
	}
	
	public Order(String name, Long epoch) {
		this.epoch = epoch;
		this.name = name;
	}
}
