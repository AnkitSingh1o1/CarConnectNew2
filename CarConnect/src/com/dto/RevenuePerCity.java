//Author : Anand Karthick

package com.dto;

public class RevenuePerCity {
    private String city;
    private double totalRevenue;
	public RevenuePerCity(String city, double totalRevenue) {
		super();
		this.city = city;
		this.totalRevenue = totalRevenue;
	}
	public RevenuePerCity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RevenuePerCity [city=" + city + ", totalRevenue=" + totalRevenue + "]";
	}
	public String getCity() {
		return city;
	}
	public double getTotalRevenue() {
		return totalRevenue;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
    
}