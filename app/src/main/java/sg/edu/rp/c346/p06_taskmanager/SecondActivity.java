package sg.edu.rp.c346.p06_taskmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    EditText etName,etDescription;
    Button btnAdd,btnCancel;
    ArrayList<Task> al;
    ArrayAdapter aa;

    int reqCode = 888;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);

        btnAdd = findViewById(R.id.btnAddTasks);
        btnCancel = findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, 5);

                Intent intent = new Intent(SecondActivity.this,
                        BroadcastReceiver.class);

                intent.putExtra("name",etName.getText().toString());
                intent.putExtra("desc",etDescription.getText().toString());

                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        SecondActivity.this, reqCode,
                        intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager)
                        getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                        pendingIntent);

                String name = etName.getText().toString();
                String description = etDescription.getText().toString();


                DBHelper dbh = new DBHelper(SecondActivity.this);
                long insert_id = dbh.insertTask(name, description);
                dbh.close();

                if (insert_id != -1) {
                    Toast.makeText(SecondActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent();
                setResult(RESULT_OK, i);
                finish();


            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
