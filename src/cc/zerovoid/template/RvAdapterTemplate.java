package cc.zerovoid.template;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.zerovoid.util.IGen;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class RvAdapterTemplate implements IGen {

	@Override
	public void gen(Configuration cfg, OutputStreamWriter writer, Template t) {
		try {
			// 模拟数据源
			Map<String, Object> data = new HashMap<>();
			data.put("package", "edu"); // 包名
			data.put("className", "Student");

			List<Map<String, String>> pros = new ArrayList<>();
			Map<String, String> pro_1 = new HashMap<>();
			pro_1.put("proType", String.class.getSimpleName());
			pro_1.put("proName", "name");
			pros.add(pro_1);

			Map<String, String> pro_2 = new HashMap<>();
			pro_2.put("proType", String.class.getSimpleName());
			pro_2.put("proName", "sex");
			pros.add(pro_2);

			Map<String, String> pro_3 = new HashMap<>();
			pro_3.put("proType", Integer.class.getSimpleName());
			pro_3.put("proName", "age");
			pros.add(pro_3);

			data.put("properties", pros);

			/*----------------------------------------*/

			List<Map<String, String>> pros2 = new ArrayList<>();

			// ArrayList<String> listValue = new ArrayList<>();
			String s = "ivGoods,llGoodInfo,tvGoodName,tvGoodsParam,tvPriceNew,tvNum,tvPriceOld";
			String[] ss = s.split(",");
			for (int i = 0; i < ss.length; i++) {
				String proName = ss[i];
				String proType = "TextView";
				if (ss[i].startsWith("tv")) {
					proType = "TextView";
				} else if (ss[i].startsWith("iv")) {
					proType = "ImageView";
				} else if (ss[i].startsWith("btn")) {
					proType = "Button";
				} else if (ss[i].startsWith("ll")) {
					proType = "LinearLayout";
				} else if (ss[i].startsWith("fl")) {
					proType = "FrameLayout";
				} else if (ss[i].startsWith("rv")) {
					proType = "RecyclerView";
				} else if (ss[i].startsWith("rl")) {
					proType = "RelativeLayout";
				} else if (ss[i].startsWith("slv")) {
					proType = "ScrollListView";
				} else {
					proType = "TextView";
				}
				Map<String, String> map = new HashMap<>();
				map.put("proType", proType);
				map.put("proName", proName);
				pros2.add(map);
			}

			data.put("properties2", pros2);

			/*----------------------------------------*/

			List<Map<String, String>> pros3 = new ArrayList<>();
			// 0=待付款,1=已付款,2=已发货,3=已完成,6=申请退款,7=已退款
			String s2 = "0=待付款,1=已付款,2=已发货,3=已完成,6=申请退款,7=已退款";
			String[] ss2 = s2.split(",");
			for (int i = 0; i < ss2.length; i++) {
				String[] ss3 = ss2[i].split("=");
				String proName = ss3[1];
				String proType = ss3[0];
				Map<String, String> map = new HashMap<>();
				map.put("proType", proType);
				map.put("proName", proName);
				pros3.add(map);
			}
			
			data.put("properties3", pros3);
			t.process(data, writer);
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
