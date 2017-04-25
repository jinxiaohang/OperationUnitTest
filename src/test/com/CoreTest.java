package test.com; 

import com.Core;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Core Tester. 
* 
* @author <Authors name> 
* @since <pre>04/23/2017</pre> 
* @version 1.0 
*/ 
public class CoreTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: Suffix(StringBuffer infix) 
* 
*/ 
@Test
public void testSuffix() throws Exception {
    Core s=new Core();
    s.Suffix(new StringBuffer("1+2+3="));
    s.Suffix(new StringBuffer("1+2×3="));
    s.Suffix(new StringBuffer("1+2÷3="));
    s.Suffix(new StringBuffer("1÷2×3="));
    s.Suffix(new StringBuffer("1÷+2×3="));
    s.Suffix(new StringBuffer("1÷2*3="));
    s.Suffix(new StringBuffer("1÷0×3="));
    s.Suffix(new StringBuffer("1÷2×0="));

} 

/** 
* 
* Method: Calculate(StringBuffer suffix) 
* 
*/ 
@Test
public void testCalculate() throws Exception { 
    Core s=new Core();
    s.Calculate(new StringBuffer("1 2 + 3 +"));
    s.Calculate(new StringBuffer("1 + 2 + 3 +"));
    s.Calculate(new StringBuffer("1 2 +"));
    s.Calculate(new StringBuffer("1 2 × 3 +"));
    s.Calculate(new StringBuffer("1+ + 2 × 3 +"));
} 


} 
