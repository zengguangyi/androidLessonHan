package tjuci.edu.dl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

public class ExpandableListActivity extends android.app.ExpandableListActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// ����һ������
		List<Map<String, String>> group = new ArrayList<Map<String, String>>();
		Map<String, String> map_group1 = new HashMap<String, String>();
		map_group1.put("group", "�������");
		group.add(map_group1);
		Map<String, String> map_group2 = new HashMap<String, String>();
		map_group2.put("group", "�������");
		group.add(map_group2);
		Map<String, String> map_group3 = new HashMap<String, String>();
		map_group3.put("group", "�������");
		group.add(map_group3);
		// �����������
		List<List<Map<String, String>>> child = new ArrayList<List<Map<String, String>>>();
		// ������������еĵ�һ��
		List<Map<String, String>> child_one = new ArrayList<Map<String, String>>();
		Map<String, String> child_one1 = new HashMap<String, String>();
		child_one1.put("child", "��սʿ");
		child_one.add(child_one1);
		Map<String, String> child_one2 = new HashMap<String, String>();
		child_one2.put("child", "����ʿ");
		child_one.add(child_one2);
		Map<String, String> child_one3 = new HashMap<String, String>();
		child_one3.put("child", "�ڰ�ʥ��");
		child_one.add(child_one3);
		Map<String, String> child_one4 = new HashMap<String, String>();
		child_one4.put("child", "���");
		child_one.add(child_one4);
		// ������������еĵڶ���
		List<Map<String, String>> child_two = new ArrayList<Map<String, String>>();
		Map<String, String> child_two1 = new HashMap<String, String>();
		child_two1.put("child", "С��");
		child_two.add(child_two1);
		Map<String, String> child_two2 = new HashMap<String, String>();
		child_two2.put("child", "����");
		child_two.add(child_two2);
		Map<String, String> child_two3 = new HashMap<String, String>();
		child_two3.put("child", "����");
		child_two.add(child_two3);
		Map<String, String> child_two4 = new HashMap<String, String>();
		child_two4.put("child", "�Ա��ɻ�");
		child_two.add(child_two4);
		// ������������еĵ�����
		List<Map<String, String>> child_three = new ArrayList<Map<String, String>>();
		Map<String, String> child_three1 = new HashMap<String, String>();
		child_three1.put("child", "��ǹ");
		child_three.add(child_three1);
		Map<String, String> child_three2 = new HashMap<String, String>();
		child_three2.put("child", "��ʿMM");
		child_three.add(child_three2);
		Map<String, String> child_three3 = new HashMap<String, String>();
		child_three3.put("child", "����");
		child_three.add(child_three3);
		// ����������ĸ����Ӽ�����List��
		child.add(child_one);
		child.add(child_two);
		child.add(child_three);
		SimpleExpandableListAdapter sel = new SimpleExpandableListAdapter(this, group, R.layout.group,
				new String[] { "group" }, new int[] { R.id.group }, child,
				R.layout.child, new String[] { "child" },
				new int[] { R.id.child });
		setListAdapter(sel);
		}
}
