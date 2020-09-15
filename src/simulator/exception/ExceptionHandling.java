package exception;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.io.BufferedReader;
import java.util.ArrayList;

public class ExceptionHandling{
    //checking if the file provided is a .txt file and that there is a file provided as input, also check if the file exist 
    public void checkInput(String args){
        try {
            File file = new File(args);
            //checking if the file exist
            if (!file.exists()){
                throw new MyException("please provide a text file as args");
            }
            Path path = FileSystems.getDefault().getPath(".", args);
            //checking the type of the file to make sure that it is a .txt file
            String mimeType = Files.probeContentType(path);
            if (!mimeType.equals("text/plain")){
                throw new MyException("file not text");
            }
        }catch(Exception e){
            if (e.getMessage() == null){
                System.out.println("please provide a text file as args");
            }else{
                System.out.println(e.getMessage());
            }
            System.exit(0);
        }        
    }

    private int countVehicles(String args){
        
        int i = -1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(args));
            while ((br.readLine()) != null){
                i++;
            }
            br.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return i;
    }

    public int getSimulation(String args){
        int i = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(args));
            i = Integer.parseInt(br.readLine());
            br.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return i;
    }
    //checking if the input file is formated correctly
    public String[][] checkFile(String args){
        String input;
        String check[];
        String vehicle[][] = new String[countVehicles(args)][5];
        ArrayList<String> observers = new ArrayList<>();
        observers.add("Baloon");
        observers.add("JetPlane");
        observers.add("Helicopter");
        int i = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(args));
            //checking if the input can be converted in an integer (if it is a number)
            if (Integer.parseInt(br.readLine()) < 1)
                throw new MyException("Invalid Simulation count the number of Simulation must be more than zero");
            //checking if there are five element after the first line of input
            while ((input = br.readLine()) != null){
                check = input.split(" ");
                if (check.length != 5){
                    throw new MyException("The file must have 5 elements in this form: TYPE NAME LONGITUDE LATITUDE HEIGHT");
                }
                // System.out.println(check[0]);
                if (!observers.contains(check[0])){
                    throw new MyException("Please insert correct vehicle");
                }
                if (Integer.parseInt(check[2]) < 1 || Integer.parseInt(check[3]) < 1 || Integer.parseInt(check[4]) < 1){
                    throw new MyException("values must not be less than zero");
                }
                Integer.parseInt(check[2]);
                Integer.parseInt(check[3]);
                Integer.parseInt(check[4]);
                vehicle[i][0] = check[0]; 
                vehicle[i][1] = check[1]; 
                vehicle[i][2] = check[2]; 
                vehicle[i][3] = check[3]; 
                vehicle[i++][4] = check[4]; 
            }
            br.close();
        }catch (NumberFormatException e) {
            System.out.println("The first line should be a interger");
            System.exit(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return (vehicle);
    }
}
