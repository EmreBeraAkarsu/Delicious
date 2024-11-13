package com.pluralsight.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFileManager {

    public void writeOrderToFile(String receipt){

        LocalDateTime localDateTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedDate = localDateTime.format(formatter);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(formattedDate + ".txt"));

            bufferedWriter.write(receipt);

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(localDateTime.toString());
            e.printStackTrace();
            System.err.println("Error writing to the file!");;
        }

    }

    public String createReceipt(Order order){

        return order.toString();

    }
}
