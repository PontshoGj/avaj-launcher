// package simulator;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;


class MyException extends Exception { 
    public MyException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}

class Exceptionhanddling{
    public void checkInput(String args){
        try {
            File file = new File(args);
            if (!file.exists()){
                throw new MyException("please provide a text file as args");
            }
            Path path = FileSystems.getDefault().getPath(".", args);
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
}

public class Simulator{
    public static void main(String[] args){
        try{
            Exceptionhanddling check = new Exceptionhanddling();
            check.checkInput(args[0]);
        }catch(Exception e){
            if (e.getMessage().equals("Index 0 out of bounds for length 0")){
                System.out.println("please provide simulation text file as args");
                System.exit(0);
            }
        }
    }
}