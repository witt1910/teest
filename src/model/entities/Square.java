package model.entities;

public class Square extends Shape {
	
	private Double side;

	public Square(Double side) {
		super();
		this.side = side;
	}
	
	@Override
	public Double area() {
		return side * side;
	}
}
