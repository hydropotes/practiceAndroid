package com.example.countcharacter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    String strCounter = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText et = (EditText)findViewById(R.id.editText);
        final TextView txtView = (TextView)findViewById(R.id.textView);
        txtView.setText(strCounter + "/80 바이트");

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 글자 변화전
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 글자 변화중
                int total = s.toString().getBytes().length;
                strCounter = Integer.toString(total);
                if(total <= 80){
                    txtView.setText(strCounter + "/80 바이트");
                }else{
                    // 입력 막기
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 글자 변화 후
            }
        });
    }

    public void onBtnClicked(View v){
        switch (v.getId()){
            case R.id.btnSend:
                popUpText();
                break;
            case R.id.btnClose:
                finishAffinity();
                System.runFinalization();
                System.exit(0);
                break;
        }
    }

    private void popUpText(){
        EditText et = (EditText)findViewById(R.id.editText);
        String txt = et.getText().toString();
        if(txt.length() != 0){
            Toast.makeText(getApplicationContext(),txt,Toast.LENGTH_SHORT).show();
        }
    }
}
