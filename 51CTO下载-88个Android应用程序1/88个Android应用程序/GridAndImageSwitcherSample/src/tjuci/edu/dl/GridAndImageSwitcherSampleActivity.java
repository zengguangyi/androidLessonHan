package tjuci.edu.dl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.ViewSwitcher.ViewFactory;

public class GridAndImageSwitcherSampleActivity extends Activity {
	/** Called when the activity is first created. */
	// ͼƬ������ID
	int[] imagesId = { R.drawable.q1, R.drawable.q2, R.drawable.q3,
			R.drawable.q4, R.drawable.q5, R.drawable.q6, R.drawable.q7,
			R.drawable.q8, R.drawable.q9, R.drawable.q10, R.drawable.q11,
			R.drawable.q12 };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ͼƬ��װ�ɼ�-ֵ�Ե���ʽ��װ��������
		List<Map<String, Object>> imageList = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < imagesId.length; i++) {
			Map<String, Object> imageMap = new HashMap<String, Object>();
			imageMap.put("image", imagesId[i]);
			imageList.add(imageMap);
		}
		// ���R.layout.main�е����Ԫ��
		GridView glv = (GridView) findViewById(R.id.gridview);
		final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageswitch);
		// ImageSwitcher�ĸ����Ķ���Ч��
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));
		// ����ͼƬ�л�Ч��
		imageSwitcher.setFactory(new ViewFactory() {
			/**
			 * ImageSwitcher����ʾmakeView()�������ص�Viewֵ
			 */
			@Override
			public View makeView() {
				ImageView iv = new ImageView(GridAndImageSwitcherSampleActivity.this);
				iv.setBackgroundColor(0xff0000);
				iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
				//��Ϊ��ImageSwitcher��ʾͼƬ  ����setLayoutParamsʱҲ�Ǵ���ImageSwitcher��LayoutParams
				iv.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				return iv;
			}
		});
		// ����������
		SimpleAdapter sa = new SimpleAdapter(this, imageList, R.layout.image,
				new String[] { "image" }, new int[] { R.id.imageview });
		glv.setAdapter(sa);
		//ѡ��ʱ�����ļ�����
		glv.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long id) {
				// TODO Auto-generated method stub
				imageSwitcher.setImageResource(imagesId[position % imagesId.length]);
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		//���ʱ�����ļ�����
		glv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long id) {
				// TODO Auto-generated method stub
				imageSwitcher.setImageResource(imagesId[position % imagesId.length]);
			}
		});
	}
}