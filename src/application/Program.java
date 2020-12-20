package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Company;
import model.entities.Individual;
import model.entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int no = sc.nextInt();
		
		for(int i = 1; i <= no; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char op = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(op == 'c') {
				System.out.print("Number of employees: ");
				int nEmp = sc.nextInt();
				list.add(new Company(name, anualIncome, nEmp));
			} else {
				System.out.print("Health expenditures: ");
				double hExp = sc.nextDouble();
				list.add(new Individual(name, anualIncome, hExp));
			}
		}

		double sum = 0;
		System.out.println("\n\nTAXES PAID:");
		for(TaxPayer tp : list) {
			System.out.println(tp.getName() + ": $ "
				+ String.format("%.2f", tp.tax()));
			sum += tp.tax();
		}
		
		System.out.printf("%nTOTAL TAXES: $ %.2f", sum);
		
		sc.close();
	}
}
