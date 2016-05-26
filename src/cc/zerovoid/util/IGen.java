package cc.zerovoid.util;

import java.io.OutputStreamWriter;

import freemarker.template.Configuration;
import freemarker.template.Template;

public interface IGen {
	void gen(Configuration cfg,OutputStreamWriter writer,Template t);
}
