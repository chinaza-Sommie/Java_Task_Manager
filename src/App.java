import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {

    public static void main(String[] args){
        EndpointActions endpoint = new EndpointActions();

        while (true) {
            System.out.println("Hello there ----- PICK AN OPERATION -------- ");
            System.out.println(" ");
            System.out.println(" Add");
            System.out.println(" Delete ");
            System.out.println(" Update ");
            System.out.println(" mark-in-progress ");
            System.out.println(" mark-done ");
            System.out.println(" list ");
            System.out.println(" list done ");
            System.out.println(" list todo ");
            System.out.println(" list in-progress ");

            String taskOperation = endpoint.getInput("");
            
            // pass date to add method
            switch (taskOperation.toLowerCase()) {
                case "add":
                    String taskDescription = endpoint.getInput(taskOperation);
                    System.out.println("Task added successfully (ID: " + endpoint.addData(taskDescription) + ")");
                    break;
                case "delete":
        
                    ArrayList<HashMap> taskArraydelete = endpoint.getArrayList();
                    for(HashMap task : taskArraydelete){
                        System.out.println(task);
                    }

                    String deleteTask = endpoint.getInput(taskOperation);

                    endpoint.deleteTask(deleteTask);

                case "update":

                    String taskID = endpoint.getInput(taskOperation);
                    Scanner newTask = new Scanner(System.in);
                    System.out.println("Enter the new task to update to: ");
                    String newTaskDescrptn = newTask.nextLine();
                    
                    endpoint.updateTask(taskID, newTaskDescrptn);
                    
                    break;

                case "list":

                    ArrayList<HashMap> taskArray = endpoint.getArrayList();
                    for(HashMap task : taskArray){
                        System.out.println(task);
                    }
                    break;
                
                case "mark-in-progress":
                case "mark-done":
                    String taskID_toMark = endpoint.getInput(taskOperation);
                    System.out.println(taskOperation + "" + taskID_toMark);
                    System.out.println(endpoint.markTaskProgress(taskID_toMark, taskOperation));
                    break;

                case "list done":
                case "list todo":
                case "list in-progress":
                    // get the main array list
                    // loop through and match the status 
                    // print the status on the screen

                    System.out.println(endpoint.listBasedOnStatus(taskOperation));

                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
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