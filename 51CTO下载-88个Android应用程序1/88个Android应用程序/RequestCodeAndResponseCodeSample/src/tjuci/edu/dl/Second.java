package tjuci.edu.dl;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Second extends ExpandableListActivity {

	//һ������
	String[] arrTypes = {"ɽ��","���","����"};
	//��������
	String[][] arr = {
			{"����","����","�麣","��ɽ"}
			,{"����","����","����","����"}
			,{"����","�ӱ�","����","�Ĵ�"}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ExpandableListAdapter ela = new BaseExpandableListAdapter() {
			
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean hasStableIds() {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded,
					View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				LinearLayout ll = new LinearLayout(Second.this);
				ll.setOrientation(0);
				TextView tv = getTextView();
				tv.setText(getGroup(groupPosition).toString());
				ll.addView(tv);
				return ll;
			}
			
			@Override
			public long getGroupId(int groupPosition) {
				// TODO Auto-generated method stub
				return groupPosition;
			}
			
			@Override
			public int getGroupCount() {
				// TODO Auto-generated method stub
				return arrTypes.length;
			}
			
			@Override
			public Object getGroup(int groupPosition) {
				// TODO Auto-generated method stub
				return arrTypes[groupPosition];
			}
			
			@Override
			public int getChildrenCount(int groupPosition) {
				// TODO Auto-generated method stub
				return arr[groupPosition].length;
			}
			
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				// TODO Auto-generated method stub
				TextView tv = getTextView();
				tv.setText(getChild(groupPosition, childPosition).toString());
				return tv;
			}
			
			@Override
			public long getChildId(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return childPosition;
			}
			
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				// TODO Auto-generated method stub
				return arr[groupPosition][childPosition];
			}
			public TextView getTextView(){
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
				TextView tv = new TextView(Second.this);
				tv.setLayoutParams(lp);
				tv.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
				tv.setPadding(36, 0, 0, 0);
				return tv;
			}
		};
		this.setListAdapter(ela);
		getExpandableListView().setOnChildClickListener(new OnChildClickListener() {
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				// TODO Auto-generated method stub
				Intent intent = getIntent();
				Bundle bundle = new Bundle();
				bundle.putString("city", arr[groupPosition][childPosition]);
				intent.putExtras(bundle);
				setResult(0, intent);
				finish();
				return false;
			}
		});
	}
	
}
