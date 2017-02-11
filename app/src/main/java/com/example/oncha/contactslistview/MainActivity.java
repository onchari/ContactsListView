package com.example.oncha.contactslistview;

import android.app.ListActivity;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

    ListView listView;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);
        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1,android.R.id.text2 };
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor,from, to);
        setListAdapter(listAdapter);
        listView = getListView();
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

    @Override
    public long getSelectedItemId() {
        return super.getSelectedItemId();
    }

    @Override
    public int getSelectedItemPosition() {
        return super.getSelectedItemPosition();
    }
}
