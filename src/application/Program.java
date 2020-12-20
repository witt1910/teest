package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Rectangle;
import model.entities.Shape;
import model.entities.Square;
import model.enums.Color;

public class Program {

	public static void main(String[] args) throws ParseException {


		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of shapes: ");
		int no = sc.nextInt();
		
		List<Shape> list = new ArrayList<>();
		
		for(int i = 1; i <= no; i++) {
			System.out.println("Shape #" + i + " data:");
			System.out.print("Rectangle or square (r/s)? ");
			char op = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED)? ");
			Color color = Color.valueOf(sc.next());
			if(op == 's') {
				System.out.print("Sides: ");
				double side = sc.nextDouble();
				list.add(new Square(side));
			} else {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				list.add(new Rectangle(width, height));
			}
		}
		
		System.out.println("\n\nSHAPE AREAS:");
		for(Shape sp : list) {
			System.out.println(sp.area());
		}

		sc.close();
	}
}
