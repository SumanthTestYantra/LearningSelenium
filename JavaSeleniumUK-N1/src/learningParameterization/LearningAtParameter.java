package learningParameterization;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearningAtParameter {
	//Learning parameterization 
	@Test
	@Parameters({"a","b"})
	public void add(@Optional("10") int a,@Optional("20") int b)
	{
		System.out.println(a+b);
	}
}
