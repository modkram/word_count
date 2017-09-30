package main;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Incorrect arguments");
            return;
        }

        Service service = new Service();

        Integer count;
        try {
            count = Integer.parseInt(args[1]);
            if(count < 1){
                System.out.println("Limit incorrect");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Limit incorrect");
            return;
        }

        File file = service.getFile(args[0]);
        if(file == null){
            System.out.println("File not found");
            return;
        }


        Map<String, Words> map = new HashMap<>();
        service.readFile(file, map);

        service.printWords(count, map);
    }
}
