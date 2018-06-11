package com.company;



import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<Integer, String> myMap = new HashMap<>();
        File file = new File("src\\myfile.txt");
        try{

            Scanner scannerInput = new Scanner(file);
            while (scannerInput.hasNextLine()) {
                String line = scannerInput.nextLine();
                int space = line.lastIndexOf(' ', line.lastIndexOf(' ') );// i need to be very clear with this
                String numb=(line.substring(0,space));
                String nameNum=line.substring(space+1);

                myMap.put(Integer.parseInt(numb),nameNum);


            }
            scannerInput.close();
        }catch (IOException E){
            E.printStackTrace();
        }

        System.out.println("please Enter a number");
        Scanner input = new Scanner(System.in);

        while(input.hasNext()) {
            Integer intvalue= input.nextInt();
            // input.nextInt();
            if (myMap.containsKey(intvalue)) {
                System.out.println(myMap.get(intvalue));
            } else {
                System.out.println("please write name how the number spelled");
                Scanner nameOfNumver = new Scanner(System.in);
                String newName = nameOfNumver.nextLine();
                myMap.put(intvalue, newName);
                System.out.println("please Enter a number");
            }
            if(input.next().equalsIgnoreCase("exit")){
                break;
            }
        }



    }
}
