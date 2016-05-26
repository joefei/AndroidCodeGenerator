package cc.zerovoid.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import cc.zerovoid.main.Test;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMaker {
	private static FreeMaker maker;
	private Configuration cfg = new Configuration();
	private String mTempPath;

	private FreeMaker() {

	}

	public static FreeMaker getMaker() {
		if (maker == null) {
			maker = new FreeMaker();
		}
		return maker;
	}

	public void init(String tempPath) {
		this.mTempPath = tempPath;
	}

	public void startGen(IGen gen, String fileName, String tempName) {
		if (mTempPath == null || mTempPath.length() > 0) {
			mTempPath = "/template";
		}
		cfg.setClassForTemplateLoading(Test.class, mTempPath);
		cfg.setSharedVariable("upperFC", new UpperFirstChar());
		try {
			Template t = cfg.getTemplate(tempName);
			FileOutputStream fos = new FileOutputStream(new File(fileName));
			gen.gen(cfg, new OutputStreamWriter(fos, "utf-8"), t);
			fos.flush();
			fos.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
