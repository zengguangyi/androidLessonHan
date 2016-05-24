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

		// 定义一级分组
		List<Map<String, String>> group = new ArrayList<Map<String, String>>();
		Map<String, String> map_group1 = new HashMap<String, String>();
		map_group1.put("group", "神族兵种");
		group.add(map_group1);
		Map<String, String> map_group2 = new HashMap<String, String>();
		map_group2.put("group", "虫族兵种");
		group.add(map_group2);
		Map<String, String> map_group3 = new HashMap<String, String>();
		map_group3.put("group", "人族兵种");
		group.add(map_group3);
		// 定义二级分组
		List<List<Map<String, String>>> child = new ArrayList<List<Map<String, String>>>();
		// 定义二级分组中的第一组
		List<Map<String, String>> child_one = new ArrayList<Map<String, String>>();
		Map<String, String> child_one1 = new HashMap<String, String>();
		child_one1.put("child", "狂战士");
		child_one.add(child_one1);
		Map<String, String> child_one2 = new HashMap<String, String>();
		child_one2.put("child", "龙骑士");
		child_one.add(child_one2);
		Map<String, String> child_one3 = new HashMap<String, String>();
		child_one3.put("child", "黑暗圣堂");
		child_one.add(child_one3);
		Map<String, String> child_one4 = new HashMap<String, String>();
		child_one4.put("child", "电兵");
		child_one.add(child_one4);
		// 定义二级分组中的第二组
		List<Map<String, String>> child_two = new ArrayList<Map<String, String>>();
		Map<String, String> child_two1 = new HashMap<String, String>();
		child_two1.put("child", "小狗");
		child_two.add(child_two1);
		Map<String, String> child_two2 = new HashMap<String, String>();
		child_two2.put("child", "刺蛇");
		child_two.add(child_two2);
		Map<String, String> child_two3 = new HashMap<String, String>();
		child_two3.put("child", "飞龙");
		child_two.add(child_two3);
		Map<String, String> child_two4 = new HashMap<String, String>();
		child_two4.put("child", "自爆飞机");
		child_two.add(child_two4);
		// 定义二级分组中的第三组
		List<Map<String, String>> child_three = new ArrayList<Map<String, String>>();
		Map<String, String> child_three1 = new HashMap<String, String>();
		child_three1.put("child", "机枪");
		child_three.add(child_three1);
		Map<String, String> child_three2 = new HashMap<String, String>();
		child_three2.put("child", "护士MM");
		child_three.add(child_three2);
		Map<String, String> child_three3 = new HashMap<String, String>();
		child_three3.put("child", "幽灵");
		child_three.add(child_three3);
		// 将二级分组的各个子集放在List中
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
