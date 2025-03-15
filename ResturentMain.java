package com.foodapp.main;

import java.util.Scanner;

import com.foodapp.dao.RestaurentInterface;
import com.foodapp.dao.UserInterface;
import com.foodapp.daoimpl.RestaurentImpl;
import com.foodapp.daoimpl.UserImpl;
import com.foodapp.model.Restaurent;
import com.foodapp.model.User;

public class ResturentMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choose=sc.nextInt();
		sc.nextLine();
		
		switch(choose) {
		
		case 1 :
			Restaurent r1=new Restaurent();
			System.out.println("Enter Restarent id");
			r1.setRestaurant_id(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Enter Restarent Name");
			r1.setRestaurant_name(sc.nextLine());
			
			System.out.println("Enter Cuisine_type");
			r1.setCuisine_type(sc.nextLine());
			
			System.out.println("Enter Delivary Time in minites");
			r1.setDelivery_time(sc.nextInt());
			sc.nextLine();
			
			System.out.println("Enter Reatarent Adress ");
			r1.setRestaurant_adress(sc.nextLine());
			
			System.out.println("Enter Restarent rating");
			r1.setRestaurant_rating(sc.nextFloat());
			sc.nextLine();
			
			System.out.println("Enter restarent is open or close ");
			r1.setRestaurant_isActive(sc.nextInt());
			
			RestaurentInterface ri1 = new RestaurentImpl(); 
			System.out.println(ri1.insert(r1)==1?"Inserted":"Not Inserted");
			
		case 2:
			RestaurentInterface ri2= new RestaurentImpl();
			for(Restaurent r2:ri2.fetchall()) {
				System.out.println(r2);
			}
			break;
			
		case 3:
			Restaurent r3=new Restaurent();
			System.out.println();
			r3.setRestaurant_id(sc.nextInt());
			RestaurentInterface ri3= new RestaurentImpl();
			for(Restaurent re3:ri3.fetchall()) {
				System.out.println(re3);
			}
			break;
			
		case 4:
			
			
		}
		
	}
}
