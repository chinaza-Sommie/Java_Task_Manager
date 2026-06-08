import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class EndpointActions {
    private String tasks;
    ArrayList<HashMap> temp_database = new ArrayList<>();

    public EndpointActions(){
       
    }

    // public HashMap<String, String> addData(String task){
    public String addData(String task){
        if(task.isEmpty()){
            // return false;
        }
        LinkedHashMap<String, String> curr_taskSet = new LinkedHashMap<>();

        String default_status = "todo";
        String new_id = "1";

        curr_taskSet.put("id" , "1");
        curr_taskSet.put("description" , task);
        curr_taskSet.put("status" , default_status);
        curr_taskSet.put("createdAt" , "1");
        curr_taskSet.put("updatedAt" , "1");

        temp_database.add(curr_taskSet); // [ {}, {}]

        return curr_taskSet.get("id");
    } 
}
