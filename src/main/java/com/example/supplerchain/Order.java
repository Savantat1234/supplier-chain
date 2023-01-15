package com.example.supplerchain;

public class Order {
    public static boolean placeOrder(String customerEmail, Product product){
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        String query = String.format("insert into orders (customer_id, product_id) values((select CUSTOMER_ID from customer where EMAIL = '%s'),'%s')",customerEmail,product.getId());
        int rowCount = 0;
        try {
            rowCount = dataBaseConnection.executeUpdateQuery(query);

        }
        catch (Exception e){
          e.printStackTrace();
        }

        return rowCount != 0;
    }
}
