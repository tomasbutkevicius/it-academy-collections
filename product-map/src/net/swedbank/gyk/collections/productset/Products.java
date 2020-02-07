package net.swedbank.gyk.collections.productset;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Products {

    Map<Product, ProductStatistics> productStatistics;

    public Products() {
        productStatistics = new HashMap();
    }

    public static void main(String[] args) throws IOException, ParseException {

        List<Reader.ProductItem> productList = Reader.readProducts("products.json");

        Products products = new Products();

        for(Reader.ProductItem item: productList) {
            products.addProduct(item.getId(), item.getName(), item.getSalesDate(), item.getAmount());
        }

        System.out.printf("We have sold %d unique items\n", products.numberOfProducts());

        products.printAll();

    }

    //implement this
    private void addProduct(String id, String name, LocalDateTime salesDate, double amount) {
        Product key = new Product(id, name);
        if(!productStatistics.containsKey(key)){
            productStatistics.put(new Product(id, name), new ProductStatistics(salesDate, salesDate, amount));
        } else {
            productStatistics.get(key).updateFirstSalesDate(salesDate);
            productStatistics.get(key).updateLastSalesDate(salesDate);
            productStatistics.get(key).updateSalesAmount(amount);
        }
    }


    //implement this
    public int numberOfProducts() {
        return productStatistics.size();
    }

    public void printAll() {
        for(Map.Entry<Product, ProductStatistics> productEntry: productStatistics.entrySet()) {
            Product product = productEntry.getKey();
            ProductStatistics stat = productEntry.getValue();

            // implement printing here
            System.out.println(productEntry.toString());
        }
    }


}
