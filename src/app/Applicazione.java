package app;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entità.Customer;
import entità.Order;
import entità.Product;

public class Applicazione {
	private static final Logger logger = LoggerFactory.getLogger(Applicazione.class);

	public static void main(String[] args) {

		Product p1 = new Product("Book 1", "Books", 39.00);
		Product p2 = new Product("Book 2", "Books", 149.00);
		Product p3 = new Product("Laptop", "Boys", 1299.00);
		Product p4 = new Product("Book 3", "Books", 129.00);
		Product p5 = new Product("Ciuccio", "Baby", 5.00);
		Product p6 = new Product("Book 4", "Books", 20.00);
		Product p7 = new Product("Biberon", "Baby", 80.00);
		Product p8 = new Product("Notebook", "Boys", 1000.00);
		Customer c1 = new Customer("Mario", 1);
		Customer c2 = new Customer("Luigi", 2);
		Customer c3 = new Customer("Ajeje", 2);

		// ESERCIZIO 1
		logger.info("ESERCIZIO 1");
		List<Product> products = Arrays.asList(p1, p2, p3, p4);
		List<Product> expensiveBooks = products.stream()
				.filter(b -> b.getCategory().equals("Books") && b.getPrice() > 100).toList();
		logger.info("Prodotti della categoria \"Books\" con prezzo >100€ :");
		logger.info(expensiveBooks.toString());

		// ESERCIZIO 2
		logger.info("ESERCIZIO 2");
		List<Product> productsOrder1 = Arrays.asList(p5, p6);
		Order order1 = new Order("New", LocalDate.now(), LocalDate.now(), productsOrder1, c1);
		List<Product> productsOrder2 = Arrays.asList(p7, p8);
		Order order2 = new Order("New", LocalDate.of(2022, 2, 20), LocalDate.now(), productsOrder2, c2);
		List<Product> productsOrder3 = Arrays.asList(p1, p2, p3, p4, p1);
		Order order3 = new Order("New", LocalDate.of(2022, 2, 20), LocalDate.now(), productsOrder3, c3);
		List<Order> orders = Arrays.asList(order1, order2, order3);
		List<Order> ordersWithBabyProducts = orders.stream()
				.filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby")))
				.toList();

		logger.info("Ordini con prodotti della categoria \"Baby\":");
		for (Order order : ordersWithBabyProducts) {
			logger.info(order.toString());
		}

		// ESERCIZIO 3
		logger.info("ESERCIZIO 3");
		List<Product> allProducts = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8);
		List<Product> boysProducts = allProducts.stream().filter(p -> p.getCategory().equals("Boys")).map(p -> {
			p.setPrice(p.getPrice() * 0.9);
			return p;
		}).toList();

		logger.info("Prodotti della categoria \"Boys\" con sconto del 10% : ");
		logger.info(boysProducts.toString());

		// ESERCIZIO 4
		logger.info("ESERCIZIO 4");
		LocalDate startDate = LocalDate.of(2022, 2, 1);
		LocalDate endDate = LocalDate.of(2022, 4, 1);
		List<Product> tier2ProductsOrdered = orders.stream()
				.filter(order -> order.getCustomer().getTier() == 2 && order.getOrderDate().isAfter(startDate)
						&& order.getOrderDate().isBefore(endDate))
				.flatMap(order -> order.getProducts().stream()).distinct().toList();
		logger.info(
				"Prodotti ordinati dai clienti di tier 2 tra 01/02/2022 e 01/04/2022: " + tier2ProductsOrdered.size());
		for (Product product : tier2ProductsOrdered) {
			logger.info(product.toString());
		}

	}

}
