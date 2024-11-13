package com.pluralsight.order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Class to generate a receipt and writing that receipt to a file
public class OrderFileManager {

    public void writeOrderToFile(String receipt){

        //Store the current date and time into the localDateTime variable
        LocalDateTime localDateTime = LocalDateTime.now();

        //Format the date and time as the requirements requires
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        //Convert the local date and time into a string using the formatter
        String formattedDate = localDateTime.format(formatter);

        try {
            //Initialize a BufferedWriter to write the recipt to the file. Name the file as the local date and time
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(formattedDate + ".txt"));

            //Write the receipt to the file
            bufferedWriter.write(receipt);

            //Close the buffered writer
            bufferedWriter.close();
        } catch (Exception e) {
            //Handle the errors
            System.out.println(localDateTime.toString());
            e.printStackTrace();
            System.err.println("Error writing to the file!");;
        }

    }

    //Method the convert the order into a string
    public String createReceipt(Order order){

        return order.toString();

    }
}
