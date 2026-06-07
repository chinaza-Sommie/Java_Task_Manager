
public class EndpointActions {
    private String tasks;

    public EndpointActions(String task){
        this.tasks = task;
    }

    public boolean getData(String data){
        return true; // dummy value
    }

    public boolean addData(String tasks){
        return true; // dummy value
    }

    public boolean updateData(String data, int id){
        return true; // dummy value
    }

    public boolean deleteData(int id){
        return true; // dummy value
    }
}
