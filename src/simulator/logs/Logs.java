package logs;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.File;  // Import the File class


public class Logs{
 
    private static Logs log = new Logs();
    public Logs(){
        try{
            File outputFile = new File("../../simulation.txt");
            outputFile.createNewFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Logs getLogs(){
        return (log);
    }

    public void wirteLog(String info){
        try{
        FileWriter writer = new FileWriter("../../simulation.txt");
        writer.write(info);
        writer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}