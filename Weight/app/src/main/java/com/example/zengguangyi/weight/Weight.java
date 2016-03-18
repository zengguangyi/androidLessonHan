package com.example.zengguangyi.weight;

/* importÏà¹Øclass */
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


public class Weight extends Activity {
    /** Called when the activity is first created. */
    public static String sex="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	    /* ÔØÈëmain.xml Layout */
        setContentView(R.layout.activity_main);
    	    /* ÒÔfindViewById()È¡µÃButton¶ÔÏó£¬²¢¼ÓÈëonClickListener */
        Button b1 = (Button) findViewById(R.id.btn_calculate);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                EditText et = (EditText)findViewById(R.id.et_height);

                double height=Double.parseDouble(et.getText().toString());
		    	    /*È¡µÃÑ¡ÔñµÄÐÔ±ð*/
                RadioGroup rg = (RadioGroup)findViewById(R.id.rg_sex);
                rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup arg0, int checkedId) {
                        // TODO Auto-generated method stub
                        if(checkedId==R.id.rb_male){
                            sex="M";
                        }
                        else{
                            sex="F";
                        }
                    }
                });
		    	    /*newÒ»¸öIntent¶ÔÏó£¬²¢Ö¸¶¨class*/
                Intent intent = new Intent();
                intent.setClass(Weight.this,Result.class);
	    	        /*newÒ»¸öBundle¶ÔÏó£¬²¢½«Òª´«µÝµÄÊý¾Ý´«Èë*/
                Bundle bundle = new Bundle();
                bundle.putDouble("height",height);
                bundle.putString("sex",sex);
	    	        /*½«Bundle¶ÔÏóassign¸øIntent*/
                intent.putExtras(bundle);
	    	        /*µ÷ÓÃActivity EX03_10_1*/
                startActivity(intent);
            }
        });
    }
}
