package logs;

import java.io.*;  // Import the File class


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
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter("../../simulation.txt", true)); 
            out.write(info); 
            out.close(); 
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}