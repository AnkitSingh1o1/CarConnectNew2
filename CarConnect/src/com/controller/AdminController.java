package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.AdminDto;
import com.model.Admin;
import com.model.Reservation;
import com.model.Review;
import com.model.Vehicle;
import com.model.Vendor;
import com.options.CustomerOptions;
import com.options.VendorOptions;
//import com.exception.ResourceNotFoundException;
import com.service.AdminService;
import com.service.ReservationService;
import com.service.ReviewService;
import com.service.VehicleService;
import com.service.VendorService;

public class AdminController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminService adminService = new AdminService();
		VendorService vendorService = new VendorService();
		Vendor vendor = new Vendor();
		ReviewService reviewService = new com.service.ReviewService();
		ReservationService reservationService = new ReservationService();
		VehicleService vehicleService = new VehicleService();

		while(true) {
			
			System.out.println("----------Welcome Admin------------");
			System.out.println("Press 1 for User Options");
			System.out.println("Press 2 for Customer Options");
			System.out.println("Press 3 for Vendor Options");
			System.out.println("Press 4 to List reservations");
			System.out.println("Press 5 to List Vehicles");
			System.out.println("Press 6 to List Reviews");
			System.out.println("Press 7 to Get Reports");
			System.out.println("Press   to Add Admin");
			System.out.println("Press   to Add Vendor");
			System.out.println("Press   to Deactivate Admin");
			System.out.println("Press   to Update Admin");
			System.out.println("Press   to Exit");
			
			//Take User input
			int input = sc.nextInt();
			
			if(input == 0) {
				System.out.println("Exiting Admin...");
				System.out.println("Exiting from Customer Module...");
				LoginController.loginController();
				break;
			}
			switch(input){
			
				case 1:
					
					System.out.println("Choose from USER options");
					UserController.userOptions();
					break;
					
					
				case 2:
				
					CustomerOptions.customerOptions();
					break;
					
					
				case 3:
					
					VendorOptions.vendorOptions();
					break;
					
					
				case 4:
					//Display all Reservations
					try {
						List<Reservation> list = reservationService.findAll();
						for(Reservation r : list) {
							System.out.println(r);
						}
					}
					catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
					
					
				case 5:
					 //Display all Vehicles
					try {
						List<Vehicle> list = vehicleService.findAll();
						for(Vehicle v : list) {
							System.out.println(v);
						}
					}
					catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					break;	
					
					
				case 6:
					//Display all Reviews
					try {
						List<Review> list = reviewService.findAll();
						for(Review r : list) {
							System.out.println(r);
						}
					}
					catch(SQLException e) {
						System.out.println(e.getMessage());
					}
					break;	
					
					
				case 7:
					
					while(true) {
						System.out.println("----------Get Reports------------");
						System.out.println("Press   for Vendor With Review Rating >= 4");//vendorWithBadReview
						System.out.println("Press   for Vendor With Review Rating < 3 ");//vendorWithGoodReview
						System.out.println("Press   to Get Reservation Count Per Customer");//getReservationCountPerCustomer(Service)
						System.out.println("Press   for City Reservation Report");
						System.out.println("Press   to Get Vehicle Stats");//getVehicleStats
						System.out.println("Press   for Get Review Stats");
						System.out.println("Press 1 for Total Revenue Report");
						System.out.println("Press 2 for Vehicle Revenue");
						System.out.println("Press 0 to Exit");
					
					
						
						int option = sc.nextInt();
						
						if(option == 0) {
							break;
						}
						
						switch(option) {
							
							case 1:
								// fetch total revenue for the reservations with completed status
								try {
									double revenue = adminService.getRevenue();
									System.out.println("The Total Revenue is : " + revenue);
									
								}
								catch(SQLException e) {
									System.out.println(e.getMessage());
								}
								break;
							
							case 2:
								
								//fetch the revenue report for each vehicle and displays vehicle_id and total revenue earned
								
								try {
									List<AdminDto> list = adminService.vehicleRevenue();
									for(AdminDto a : list) {
										System.out.println(a);
									}
								}
								catch(SQLException e) {
									System.out.println(e.getMessage());
								}
		
									break;
							
							case 3:
								
								//Display the list of city and the number of reservations for each city
								
								
								break;
	
							case 4:
								break;
							}
						}
				case 8 :
					
					Random random = new Random();
					int randomNumber = random.nextInt();
					int adminId = randomNumber < 0 ? randomNumber*(-1) : randomNumber;
					sc.nextLine();
					System.out.println("Enter Admin First Name");
					String adminFName = sc.nextLine();
					System.out.println("Enter Admin Last Name");
					String adminLName = sc.nextLine();
					System.out.println("Enter Admin Email");
					String adminEmail = sc.nextLine();
					System.out.println("Enter Admin Phone Number");
					String adminPhoneNumber = sc.nextLine();
					System.out.println("Enter Admin Role");
					String adminRole = sc.nextLine();
					System.out.println("Enter Admin Join Date");
					String adminJoinDate = sc.nextLine();
					
					Admin admin = new Admin(adminId,adminFName,adminLName,adminEmail,adminPhoneNumber,adminRole,adminJoinDate);
				try {
					int status = adminService.addAdmin(admin);
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
					
					
					break;
			}
			
			
		}
	

	}
	
	public static void adminMenu() {
		String[] charary = {""};
		main(charary);
	}

}
