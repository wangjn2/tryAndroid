package jnw.android.trygradle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HelloWorldActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 中文测试
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }
}
