package tjuci.edu.dl;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class XmlResourceParserSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button)findViewById(R.id.btn);
        final EditText edit = (EditText)findViewById(R.id.edit);
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				XmlResourceParser xpr = XmlResourceParserSampleActivity.this.getResources().getXml(R.xml.myxml);
				StringBuilder sb = new StringBuilder();
				try {
					//xml没到最后  做循环
					while(xpr.getEventType() != XmlResourceParser.END_DOCUMENT){
						if(xpr.getEventType() == XmlResourceParser.START_TAG){
							//获取标签的标签名
							String	name = xpr.getName();
							if(name.equals("book")){
								sb.append("价格：" + xpr.getAttributeValue(null, "price"));
								sb.append("出版日期："+ xpr.getAttributeValue(1));
								try {
									sb.append("书名：" + xpr.nextText());
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						try {
							xpr.next();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					edit.setText(sb.toString());
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
    }
}