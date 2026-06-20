import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EndpointActions {
    private String tasks;
    private Integer new_id = 0;
    private final String json_file = "database.json";
    ArrayList<HashMap> temp_database = new ArrayList<>();

    public EndpointActions(){
        createFileIfNotExist();
        loadTasks();
    }

    private void createFileIfNotExist(){
        File file = new File(json_file);

        if(!file.exists()){
            try{
                file.createNewFile();

                FileWriter writer = new FileWriter(file);
                writer.write("[]");
                writer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    private void saveTasks(){
        try{
            FileWriter writer = new FileWriter(json_file);

            writer.write("[\n");

            for(int i = 0; i < temp_database.size(); i++){
                HashMap<String, String> task = temp_database.get(i);

                writer.write(" {\n");
                writer.write("   \"id\": \"" + task.get("id") + "\",\n");
                writer.write("    \"description\": \"" +
                    task.get("description") + "\",\n");
                writer.write("    \"status\": \"" +
                    task.get("status") + "\",\n");
                writer.write("    \"createdAt\": \"" +
                    task.get("createdAt") + "\",\n");
                writer.write("    \"updatedAt\": \"" +
                    task.get("updatedAt") + "\"\n");
                writer.write(" }");

                if(i < temp_database.size() - 1){
                    writer.write(",");
                }

                writer.write("\n");
            }
            writer.write("]");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
   
    private String getDateTime(){
        LocalDateTime createdAt = LocalDateTime.now();
        DateTimeFormatter formattedCreatedAt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDateTime = createdAt.format(formattedCreatedAt);
        return formattedDateTime;
    }

    public ArrayList<HashMap> getArrayList(){
        return temp_database;
    }

    private void loadTasks() {

        try {

            String content = Files.readString(Paths.get(json_file));

            if (content.equals("[]")) {
                return;
            }

            parseJson(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String addData(String task){
        if(task.isEmpty()){
            // return false;
        }
        LinkedHashMap<String, String> curr_taskSet = new LinkedHashMap<>();

        String default_status = "todo";
        new_id+=1;
        String formattedDateTime = getDateTime();
        curr_taskSet.put("id" , new_id.toString());
        curr_taskSet.put("description" , task);
        curr_taskSet.put("status" , default_status);
        curr_taskSet.put("createdAt" , formattedDateTime);
        curr_taskSet.put("updatedAt" , "00-00-0000");

        temp_database.add(curr_taskSet);
        saveTasks();
        return curr_taskSet.get("id");
    }

    private void parseJson(String json) {

        json = json.trim();

        json = json.substring(1, json.length() - 1);

        if (json.isBlank()) {
            return;
        }

        String[] objects = json.split("\\},\\s*\\{");

        for (String object : objects) {

            object = object.replace("{", "");
            object = object.replace("}", "");

            LinkedHashMap<String, String> task = new LinkedHashMap<>();

            String[] pairs = object.split(",");

            for (String pair : pairs) {

                String[] keyValue = pair.split(":");

                String key = keyValue[0]
                        .replace("\"", "")
                        .trim();

                String value = keyValue[1]
                        .replace("\"", "")
                        .trim();

                task.put(key, value);
            }

            temp_database.add(task);

            int id = Integer.parseInt(task.get("id"));

            if (id > new_id) {
                new_id = id;
            }
        }
    }

    public String getInput(String operation){
        Scanner scanned_taskDescription = new Scanner(System.in);

        if(operation == null || operation.isEmpty()){
            System.out.println("Enter the Operation Name : ");
        }else if(operation.equalsIgnoreCase("delete")){
            System.out.println("Enter the task ID to delete: ");
        }else if(operation.equalsIgnoreCase("add")){
            System.out.println("Enter the task to perform: ");
        }else if(operation.equalsIgnoreCase("update")){
            System.out.println("Enter the task ID to update: ");
        }else if(operation.equalsIgnoreCase("mark-in-progress")){
            System.out.println("Enter the task ID to mark-in-progres: ");
        }else if(operation.equalsIgnoreCase("mark-done")){
            System.out.println("Enter the task ID to mark-done: ");
        }else{
            return null;
        }
        String taskDescription = scanned_taskDescription.nextLine();

        return taskDescription;
    }

    public ArrayList<HashMap> deleteTask(String taskID){
        
        Iterator<HashMap> iterator = temp_database.iterator();

        while(iterator.hasNext()){
            HashMap task = iterator.next();
            // COMEBACK : check if taskID is the last id and remove by 1 after delete is successful
            if(task.get("id").equals(taskID)){
                iterator.remove();
                System.out.println("Task deleted successfully (ID: " + taskID + " )");
                saveTasks();
                return temp_database;
            }
        }
        System.out.println("Task Not found:" + taskID);
        return temp_database;
    }

    public String updateTask(String taskID, String task){
        // ArrayList<HashMap> currentTasks = getArrayList();

        if(task.isEmpty() || taskID.isEmpty()){
            return "Please, enter task to update";
        }
        String formattedDateTime = getDateTime();

        for(HashMap tasks : temp_database){
            if(tasks.get("id").equals(taskID)){
                tasks.put("description" , task);
                tasks.put("updatedAt" , formattedDateTime);
                saveTasks();
                System.out.println("Task updated successfully");
                return "Task updated successfully";
            }
        }

        System.out.println("something went wrong"+ taskID + " " + task);
        return "try again";
    }

    public String markTaskProgress(String taskID, String status){
        if(taskID.isEmpty() || status.isEmpty() || taskID == null || status == null){
            return "Please, enter the right task ID or status";
        }

        String setStatus;

        if(status.equalsIgnoreCase("mark-in-progress")){
            setStatus = "in-progress";
        }else if(status.equalsIgnoreCase("mark-done")){
            setStatus = "done";
        }else{
            return "invalid status";
        }

        for(HashMap tasks : temp_database){
            if(tasks.get("id").equals(taskID)){
                tasks.put("status", setStatus);
                saveTasks();
                return "Status Updated Successfully";
            }
        }

        return "Try again";
    }

    public String listBasedOnStatus(String status){

        if(status == null || status.isEmpty()){
            return "Invalid status. Try again";
        }
        String getStatus;
        boolean ifFound = false;

        if(status.equalsIgnoreCase("list done")){
            getStatus = "done";
        }else if(status.equalsIgnoreCase("list todo")){
            getStatus = "todo";
        }else if(status.equalsIgnoreCase("list in-progress")){
            getStatus = "in-progress";
        }else{
            return "invalid status";
        }

        for(HashMap tasks : temp_database){
            if(tasks.get("status").equals(getStatus)){
                System.out.println(tasks);
                ifFound = true;
            }
        }

        if(ifFound){
            return " Tasks Displayed Succesfully";
        }
        
        return "something went wrong. Try again";
    }
}
