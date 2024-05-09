package TestUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;



public class Transformer implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Class Testclass,Constructor Testconstrunctor, Method TestMethod)
	{
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

}
