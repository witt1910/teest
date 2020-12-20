package model.entities;

public class Individual extends TaxPayer {

	private Double healthExpenditures;
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		double tax = 0;
		if(anualIncome < (anualIncome * 0.2)) {
			tax += anualIncome * 0.15;
		} else {
			tax += anualIncome * 0.25;
		}
		
		if(healthExpenditures > 0) {
			tax -= healthExpenditures * 0.5;
		}
		return tax;
	}
}
