package net.swedbank.gyk.collections.productset;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Reader {

    public static class ProductItem {
        private String id;
        private String name;
        private LocalDateTime salesDate;
        private double amount;

        public ProductItem(String id, String name, LocalDateTime salesDate, double amount) {
            this.id = id;
            this.name = name;
            this.salesDate = salesDate;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDateTime getSalesDate() {
            return salesDate;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static List<ProductItem> readProducts(String fileName) throws ParseException, IOException {

        List<ProductItem> products = new ArrayList<>();
        File productsFile = Paths.get(System.getProperty("user.dir"), fileName).toFile();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(productsFile.toString());
        JSONArray jsonItems = (JSONArray) parser.parse(reader);

        Iterator<JSONObject> productsIterator = jsonItems.iterator();

        DateTimeFormatter formatter = getFormatter();

        while(productsIterator.hasNext()) {
            JSONObject docObj = productsIterator.next();
            ProductItem productItem = new ProductItem(
                    (String)docObj.get("productId"),
                    (String)docObj.get("productName"),
                    LocalDateTime.parse((String)docObj.get("saleDate"), formatter),
                    Double.parseDouble((String)docObj.get("amount")));

            products.add(productItem);
        }

        return products;
    }

    private static  DateTimeFormatter getFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    }

}
