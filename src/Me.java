 public class Me {
   public static void main(String[] args) {
     String name = (args[0]);
	 int age = Integer.parseInt(args[1]);
   Person jabir = new Person(name, age);
   String output = String.format("***Me***\n\nName: %s\nAge Next Year: %d\n\n", jabir.name, jabir.AgeNextYear());
   System.out.println(output);
    }
   }	
   
