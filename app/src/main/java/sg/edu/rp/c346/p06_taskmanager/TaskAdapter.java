package sg.edu.rp.c346.p06_taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    TextView tvTaskName, tvDescription,tvid;
    Context context;
    ArrayList<Task> tasks;
    int resource;

    public TaskAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tvTaskName = (TextView) rowView.findViewById(R.id.tvid);
        tvDescription = (TextView) rowView.findViewById(R.id.tvDescriptions);
        tvid = (TextView) rowView.findViewById(R.id.tvid);

        Task task = tasks.get(position);
        int id = tvid.getId();

        tvTaskName.setText(task.getTaskName());
        tvDescription.setText(task.getDescriptions());

        return rowView;


    }

}
