package com.example.posttest_pwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EntryDataActivity extends AppCompatActivity {
    Button buttonAdd;
    EditText editJudul;
    EditText editIsi;
    Context context;
    String nomor = "Submit", submit;
    Data update;
    DatabaseReference databaseData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_data);
        context = this;
        buttonAdd = (Button) findViewById(R.id.add_data);
        editJudul = (EditText) findViewById(R.id.editjudul);
        editIsi = (EditText) findViewById(R.id.editisi);
        submit = getIntent().getStringExtra("UPDATE_ACTION");
        update = getIntent().getParcelableExtra("UPDATE_INTENT");
        databaseData = FirebaseDatabase.getInstance().getReference("Data");
        if (submit == null){
            submit = "Submit";
        }else  {
            nomor = String.valueOf(update.getDataid());
        }

        if(submit.equals("Edit")){
            buttonAdd.setText("Edit");
            editJudul.setText(update.getDatatitle());
            editIsi.setText(update.getDataisi());
        }



        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String label = buttonAdd.getText().toString();
                if (label.equals("Tambah")){
                    addData();
                }

                if (label.equals("Edit")){
                    String id = update.getDataid();
                    String judul = update.getDatatitle();
                    String isi = update.getDataisi();
                    SimpleDateFormat tanggal = new SimpleDateFormat("dd/MM/yyyy' 'hh:mm:ss");
                    String tglsekarang = tanggal.format(new Date());
                    if (TextUtils.isEmpty(judul)){
                        editJudul.setError("Judul kosong");
                        return;
                    }
                    Updatedata(tglsekarang, id,judul,isi);
                }

            }
        });
    }

    private void addData() {
        databaseData = FirebaseDatabase.getInstance().getReference("Data");
        String judul = editJudul.getText().toString().trim();
        String isi = editIsi.getText().toString().trim();
        SimpleDateFormat tanggal = new SimpleDateFormat("dd/MM/yyyy' 'hh:mm:ss");
        String tglsekarang = tanggal.format(new Date());
        if (!TextUtils.isEmpty(judul)) {

            String id = databaseData.push().getKey();

            Data data = new Data(tglsekarang,id,judul,isi);

            databaseData.child(id).setValue(data);

            Toast.makeText(this, "Data added", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You should enter a Title", Toast.LENGTH_LONG).show();
        }
    }
    private boolean Updatedata(String tanggal,String id, String judul, String isi){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Data").child(id);
        Data data= new Data(tanggal, id, judul, isi);

        databaseReference.setValue(data);

        Toast.makeText(this, "Data Updated Succesfully", Toast.LENGTH_LONG).show();

        return true;

    }

}
