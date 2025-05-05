package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class application {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println();
		List<Product> products = new ArrayList<>();

		System.out.print("Enter the number of product:");
		Integer quantidade = sc.nextInt();

		for (int i=0; i<quantidade; i++) {
			System.out.println("Product #" + (i+1) + " data:");
			System.out.println("Common, used or imported (c/u/i)? ");
			char typeProduct = sc.next().charAt(0);

			System.out.println("Name: ");
			String name = sc.nextLine();

			System.out.println("Price: ");
			Double price = sc.nextDouble();

			if (typeProduct == 'c') {
				Product product = new Product(name, price);
				products.add(product);
				} else if (typeProduct == 'i') {
					System.out.println("Customs Fee: ");
					Double customsFee = sc.nextDouble();
					Product product = new ImportedProduct(name, price, customsFee);
					products.add(product);
					} else {
						System.out.println("Manufacture date (DD/MM/YYYY): ");
						String date = sc.next();
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate manufactureDate = LocalDate.parse(date, fmt);
						Product product = new UsedProduct(name, price, manufactureDate);
						products.add(product);
					}

		}

		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product prod : products) {
			System.out.println(prod.priceTag());
		}

		sc.close();
	}
}
