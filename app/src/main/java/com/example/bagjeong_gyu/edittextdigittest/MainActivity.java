package com.example.bagjeong_gyu.edittextdigittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String birthDate = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText editText = (EditText) findViewById(R.id.editText);
       editText.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

           }

           @Override
           public void afterTextChanged(Editable s) {

               Log.d("digit", "digit: " + s.charAt(s.length() - 1));
               Log.d("digit", "digit length: " + s.length());
               InputFilter[] filters = s.getFilters(); // save filters
               s.setFilters(new InputFilter[]{});


               Log.d("digit", "step0");
               if(birthDate.length() < s.length()){

                     //7번째 숫자가 1,2(한국인 남녀), 3,4(2000년이후 출생 남녀) 5,6(외국인 남녀)가 아니면 삭제
                   //2016-02-18 박정규

                   switch(s.length()){
                       case 7:
                           Log.d("digit", "step1");
                           //insert하면 아래코드 안 타고 바로 case 8로 넘어감
                           s.insert(6, " ");

//                           if(Integer.parseInt(s.charAt(7)+"") >=        7) {
//                               Log.d("digit", "step2");
//
//                               //delete(6,7)하면 6번째 char만 삭제
//                               s.delete(s.length() - 2,
//                                       s.length());
//                           }
                           break;
                       case 8:
                           if(Integer.parseInt(s.charAt(7)+"") >=        7) {
                               Log.d("digit", "step2");

                               //delete(6,7)하면 6번째 char만 삭제
                               s.delete(s.length() - 1,
                                       s.length());
                           }
                           break;

                   }
               }
               s.setFilters(filters);
               birthDate = s.toString();

           }
       });
    }
}
