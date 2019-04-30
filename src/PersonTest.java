import org.junit.Test;
import static or.junit.Assert.assertEquals;

public class PersonAgeTest
  { 
  Person jabir = new Person('jabir',39);
  
  @Test
  public void testAgenextyear()
    {
    assertEquals(jabir.AgeNextYear(),40);
    }
  }	
