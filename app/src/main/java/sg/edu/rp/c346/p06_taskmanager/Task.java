package sg.edu.rp.c346.p06_taskmanager;

import java.io.Serializable;

public class Task implements Serializable {

    private int ID;
    private String taskName;
    private String descriptions;

    public Task(int ID, String taskName, String descriptions) {
        this.ID = ID;
        this.taskName = taskName;
        this.descriptions = descriptions;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
