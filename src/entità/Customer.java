package entità;

import java.util.UUID;

public class Customer {
	private UUID id;
	private String name;
	private Integer tier;

	public Customer(String name, Integer tier) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.tier = tier;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getTier() {
		return tier;
	}
}
