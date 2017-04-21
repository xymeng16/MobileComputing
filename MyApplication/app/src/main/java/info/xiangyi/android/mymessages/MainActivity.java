package info.xiangyi.android.mymessages;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Contacts;
import android.telephony.SmsMessage;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MainActivity extends ListActivity {

    public static final String INBOX = "content://sms/inbox";
    public static final String SENT = "content://sms/sent";
    public static final String DRAFT = "content://sms/draft";
    public static MainActivity activity;
    public List<String> list;
    ArrayAdapter<String> adapter;
    HashSet<String> hashList;
    public static MainActivity instance() {
        return activity;
    }
    @Override
    public void onStart() {
        super.onStart();
        activity = this;
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grantUriPermission("com.android.providers.telephony.SmsProvider", Uri.parse("content://sms/inbox"), Intent.FLAG_GRANT_READ_URI_PERMISSION);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        int REQUEST_CODE_ASK_PERMISSIONS = 123;
        requestPermissions(new String[]{"android.permission.READ_SMS"}, REQUEST_CODE_ASK_PERMISSIONS);
        Cursor cursor = getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        hashList = new HashSet<>();
        setListAdapter(adapter);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            do {
                String msgData = "";
                for (int idx = 0; idx < cursor.getColumnCount(); idx++) {
                    if ("body".equals(cursor.getColumnName(idx)))
                        msgData = cursor.getString(idx);
                }
                // use msgData
                list.add(msgData);
            } while (cursor.moveToNext());
        } else {
            // empty box, no SMS
            list.add("No message.");
        }
        adapter.notifyDataSetChanged();
    }
    public void addMsg(String msg) {
        list.add(msg);
        adapter.notifyDataSetChanged();
    }
}
