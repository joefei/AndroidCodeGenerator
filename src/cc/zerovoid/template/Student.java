package cc.zerovoid.template;

import java.io.File;
import java.io.FileOutputStream;
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

public class Student implements IGen {

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
