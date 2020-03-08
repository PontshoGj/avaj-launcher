// package simulator;

import exception.*;

public class Simulator{
    public static void main(String[] args){
        try{
            ExceptionHandling check = new ExceptionHandling();
            check.checkInput(args[0]);
            check.checkFile(args[0]);
        }catch(Exception e){
            if (e.getMessage().equals("Index 0 out of bounds for length 0")){
                System.out.println("please provide simulation text file as args");
                System.exit(0);
            }
        } 
    }
}