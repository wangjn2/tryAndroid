package jnw.android.trygradle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HelloWorldActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "jnw.android.trygradle.MESSAGE";


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
}
