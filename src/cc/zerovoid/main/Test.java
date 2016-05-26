package cc.zerovoid.main;

import cc.zerovoid.template.RvAdapterTemplate;
import cc.zerovoid.template.Student;
import cc.zerovoid.util.FreeMaker;

public class Test {

	public static void main(String[] args) {
//		FreeMaker.getMaker().startGen(new Student(), "F:/Adapter.java",
//				"StudentTemplate.html");
		
		FreeMaker.getMaker().startGen(new RvAdapterTemplate(), "F:/Adapter2.java",
				"RvAdapterTemplate.html");
	}

}
