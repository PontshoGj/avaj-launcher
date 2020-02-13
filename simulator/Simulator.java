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

public class Simulator{
    public static void main(String[] args){

        try {
            File file = new File(args[0]);
            System.out.println(file.exists());
            Path path = FileSystems.getDefault().getPath(".", args[0]);
            String mimeType = Files.probeContentType(path);
            System.out.println(mimeType.equals("text/plain"));
            if (!mimeType.equals("text/plain")){
                System.out.println("aaaa");
                throw new MyException("file not text");
            }
        }catch(Exception e){
            // if (e)
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}