package entità;

import java.util.UUID;

public class Product {
	private UUID id;
	private String name;
	private String category;
	private Double price;

	public Product(String name, String category, Double price) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "{Product-id: " + id + ", name: '" + name + '\'' + ", category: '" + category + '\'' + ", price: "
				+ price + " €}";
	}
}