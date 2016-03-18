package com.example.zengguangyi.weight;

/* importÏà¹Øclass */
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends Activity 
{
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    /* ¼ÓÔØmain.xml Layout */
    setContentView(R.layout.activity_result);
    /* È¡µÃIntentÖÐµÄBundle¶ÔÏó */
    Bundle bunde = this.getIntent().getExtras();   
    /* È¡µÃBundle¶ÔÏóÖÐµÄÊý¾Ý */
    String sex = bunde.getString("sex");
    double height = bunde.getDouble("height");  
    /*ÅÐ¶ÏÐÔ±ð */
    String sexText="";
    if(sex.equals("M")){
      sexText="ÄÐÐÔ";
    }else{
      sexText="Å®ÐÔ";
    }    
    /* È¡µÃ±ê×¼ÌåÖØ */
    String weight=this.getWeight(sex, height);
    
    /* Éè¶¨Êä³öÎÄ×Ö */
    TextView tv1=(TextView) findViewById(R.id.text1);
    tv1.setText("ÄãÊÇÒ»Î»"+sexText+"\nÄãµÄÉí¸ßÊÇ"+height+ "¹«·Ö\nÄãµÄ±ê×¼ÌåÖØÊÇ"+weight+"¹«½ï");
  }
  
  /* ËÄÉáÎåÈëµÄmethod */
  private String format(double num)
  {
      NumberFormat formatter = new DecimalFormat("0.00");
      String s=formatter.format(num);
      return s;
  }

  /* ÒÔfindViewById()È¡µÃButton¶ÔÏó£¬onClickListener */  
  private String getWeight(String sex,double height)
  {
      String weight="";
      if(sex.equals("M"))
      {
        weight=format((height-80)*0.7);
        }else
      {
        weight=format((height-70)*0.6);
      } 
        return weight;
      }
}


