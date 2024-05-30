//Author : Anand Karthick

package com.dto;

public class VendorsByCityDto {
	private int vendor_id;
	private String vendor_first_name;
	private String vendor_last_name;
	private String vendor_email;
	private String vendor_phone_number;
	private String vendor_registration_date;
	private String city;
	public VendorsByCityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorsByCityDto(int vendor_id, String vendor_first_name, String vendor_last_name, String vendor_email,
			String vendor_phone_number, String vendor_registration_date, String city) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_first_name = vendor_first_name;
		this.vendor_last_name = vendor_last_name;
		this.vendor_email = vendor_email;
		this.vendor_phone_number = vendor_phone_number;
		this.vendor_registration_date = vendor_registration_date;
		this.city = city;
	}
	public int getVendor_id() {
		return vendor_id;
	}
	public String getVendor_first_name() {
		return vendor_first_name;
	}
	public String getVendor_last_name() {
		return vendor_last_name;
	}
	public String getVendor_email() {
		return vendor_email;
	}
	public String getVendor_phone_number() {
		return vendor_phone_number;
	}
	public String getVendor_registration_date() {
		return vendor_registration_date;
	}
	public String getCity() {
		return city;
	}
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
	}
	public void setVendor_first_name(String vendor_first_name) {
		this.vendor_first_name = vendor_first_name;
	}
	public void setVendor_last_name(String vendor_last_name) {
		this.vendor_last_name = vendor_last_name;
	}
	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}
	public void setVendor_phone_number(String vendor_phone_number) {
		this.vendor_phone_number = vendor_phone_number;
	}
	public void setVendor_registration_date(String vendor_registration_date) {
		this.vendor_registration_date = vendor_registration_date;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "VendorsByCityDto [vendor_id=" + vendor_id + ", vendor_first_name=" + vendor_first_name
				+ ", vendor_last_name=" + vendor_last_name + ", vendor_email=" + vendor_email + ", vendor_phone_number="
				+ vendor_phone_number + ", vendor_registration_date=" + vendor_registration_date + ", city=" + city
				+ "]";
	}
	
	
}
