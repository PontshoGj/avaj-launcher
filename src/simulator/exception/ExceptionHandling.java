import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.FileSystems;
import java.io.BufferedReader;


class Exceptionhandling{
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

    //checking if the input file is formated correctly
    public void checkFile(String args){
        int i = 0;
        String input;

        try{
            BufferedReader br = new BufferedReader(new FileReader(args));
            //checking if the input can be converted in an integer (if it is a number)
            Integer.parseInt(br.readLine());
            //checking if there are five element after the first line of input
            while ((input = br.readLine()) != null){
                if (input.split(" ").length != 5){
                    throw new MyException("The file must have 5 elements in this form: TYPE NAME LONGITUDE LATITUDE HEIGHT");
                }
            }
        }catch (NumberFormatException e) {
            System.out.println("The first line should be a interger");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
