package ua.opnu;

import ua.opnu.util.Customer;
import ua.opnu.util.DataProvider;
import ua.opnu.util.Order;
import ua.opnu.util.Product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class HardTasks {

    private final List<Customer> customers = DataProvider.customers; // пусть остается, даже если не используется
    private final List<Order> orders = DataProvider.orders;
    private final List<Product> products = DataProvider.products;

    public List<Product> getBooksWithPrice() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .filter(p -> p.getPrice() > 100)
                .toList();
    }

    public List<Order> getOrdersWithBabyProducts() {
        return orders.stream()
                .filter(order -> order.getProducts().stream()
                        .anyMatch(p -> "Baby".equals(p.getCategory())))
                .toList();
    }

    public List<Product> applyDiscountToToys() {
        return products.stream()
                .filter(p -> "Toys".equals(p.getCategory()))
                .peek(p -> p.setPrice(p.getPrice() * 0.5))
                .toList();
    }

    public Optional<Product> getCheapestBook() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .min(Comparator.comparing(Product::getPrice));
    }

    public List<Order> getRecentOrders() {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toList();
    }

    public DoubleSummaryStatistics getBooksStats() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    public Map<Integer, Integer> getOrdersProductsMap() {
        return orders.stream()
                .collect(
                        LinkedHashMap::new,
                        (map, order) -> map.put(order.getId(), order.getProducts().size()),
                        LinkedHashMap::putAll
                );
    }

    public Map<String, List<Integer>> getProductsByCategory() {
        return products.stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                LinkedHashMap::new,
                                Collectors.mapping(Product::getId, Collectors.toList())
                        )
                );
    }
}
