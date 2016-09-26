package jnw.android.trygradle;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HelloWorldActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "jnw.android.trygradle.MESSAGE";
    public final static int PICK_CONTACT_REQUEST = 17;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 中文测试
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }

    public void pickContact(View view) {
        // Create an intent to "pick" a contact, as defined by the content provider URI
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // If the request went well (OK) and the request was PICK_CONTACT_REQUEST
        if (resultCode == Activity.RESULT_OK && requestCode == PICK_CONTACT_REQUEST) {
            // Perform a query to the contact's content provider for the contact's name
            Cursor cursor = getContentResolver().query(data.getData(),
                    new String[] {ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
            if (cursor.moveToFirst()) { // True if the cursor is not empty
                int columnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
                String name = cursor.getString(columnIndex);
                // Do something with the selected contact's name...

                EditText editText = (EditText) findViewById(R.id.edit_message);
                editText.append(name);
            }
        }
    }
}
