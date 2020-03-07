import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.io.BufferedReader;

class MyException extends Exception { 
    public MyException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}