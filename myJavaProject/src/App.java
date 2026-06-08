import java.util.Scanner;

public class App {

    public static void main(String[] args){
        EndpointActions endpoint = new EndpointActions();

        System.out.println("Hello there ----- PICK AN OPERATION -------- ");
        System.out.println(" ");

        Scanner scanned_taskDescription = new Scanner(System.in);
        System.out.println("Enter the new task description: ");

        String taskDescription = scanned_taskDescription.nextLine();
        // pass date to add method
        if(!taskDescription.isEmpty()){
            System.out.println("Task added successfully (ID: " + endpoint.addData(taskDescription) + ")");
        }else{
            
            System.out.println("Try again");
        }
    }
}

























// try{
//             File dummyData = new File("myJavaProject/dummy_database.json");
            
//             if(dummyData.createNewFile()){
//                 System.out.println("File created: " + dummyData.getName());
//             }


        
//         }catch(IOException e){
//             e.printStackTrace();
//         }