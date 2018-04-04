package fr.wildcodeschool.roomreservation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RoomCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_create);

        Button btCreate = findViewById(R.id.button_create_room);
        btCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText etRoomname = findViewById(R.id.edit_roomname);

                String roomname = etRoomname.getText().toString();

                addRoomToDB(roomname);

                Intent intent = new Intent(RoomCreateActivity.this, MainActivity.class);
                RoomCreateActivity.this.startActivity(intent);
            }
        });
    }

    private void addRoomToDB(String roomname) {
        DbHelper mDbHelper = new DbHelper(RoomCreateActivity.this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues room = new ContentValues();
        room.put(DBContract.RoomEntry.COLUMN_NAME_ROOMNAME, roomname);
        long newRoomId = db.insert(DBContract.RoomEntry.TABLE_NAME, null, room);

        Toast.makeText(this, String.valueOf(newRoomId), Toast.LENGTH_LONG).show();
    }
}
