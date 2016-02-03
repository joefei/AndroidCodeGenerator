package com.zerovoid.main;

import com.zerovoid.template.RvAdapterTemplate;
import com.zerovoid.template.Student;
import com.zerovoid.util.FreeMaker;

public class Test {

	public static void main(String[] args) {
//		FreeMaker.getMaker().startGen(new Student(), "F:/Adapter.java",
//				"StudentTemplate.html");
		
		FreeMaker.getMaker().startGen(new RvAdapterTemplate(), "F:/Adapter2.java",
				"RvAdapterTemplate.html");
	}

}
