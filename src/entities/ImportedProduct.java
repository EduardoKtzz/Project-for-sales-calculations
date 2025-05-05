package entities;

public class ImportedProduct extends Product {

	//Atributos
	private Double customsFee;

	public ImportedProduct() {

	}

	public ImportedProduct(Double customsFee) {
		this.customsFee = customsFee;
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return getName() + " $" + String.format("%.2f", totalPrice()) + "(Customs fee: $ " + customsFee + ")";

	}

	public Double totalPrice() {
		return getPrice() + customsFee;
	}

	
}
