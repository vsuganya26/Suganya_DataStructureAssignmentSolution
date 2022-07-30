package com.gl.driver;

import java.util.Scanner;

import com.gl.services.SkyscraperService;

public class Main {

	public static void main(String[] args) {

		SkyscraperService ss = new SkyscraperService();

		Scanner sc = new Scanner(System.in);

		// Getting no of floors as input from the user
		System.out.println("Enter the total no of floors in the building :");
		int totalNoOfFloors = sc.nextInt();

		// Floor sizes for each given day
		int[] noOfFloorEachDay = new int[totalNoOfFloors];
		for (int i = 0; i < totalNoOfFloors; i++) {
			System.out.println("Enter the floor size given on day : " + (i + 1));
			noOfFloorEachDay[i] = sc.nextInt();
		}

		System.out.println("The order of construction is as follows : ");
		ss.displayConstructionOrder(totalNoOfFloors, noOfFloorEachDay);

		sc.close();

	}
}
