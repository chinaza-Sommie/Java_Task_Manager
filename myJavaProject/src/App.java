import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class App {
    // functions : Add, Delete, Update
    // Mark a task as inprogress or done
    // list all tasks
    // list all tasks that are done

    // solution process:
    // 1. accept input
    // error handling for the input
    // pass the input using the data gotten

    public static void main(String[] args){
        try{
            File dummyData = new File("myJavaProject/dummy_database.json");
            
            if(dummyData.createNewFile()){
                System.out.println("File created: " + dummyData.getName());
            }
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
