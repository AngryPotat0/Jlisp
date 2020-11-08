import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class JLisp {
	private static Env globalEnv = new Env();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		String program = cin.nextLine();
		Exp lispProgram = Parse.parse(program);
		// test(lisp);
//		System.out.println(output(eval(lispProgram,globalEnv)));
		
	}

	private static void test(Exp lisp){
		// System.out.println(lisp.type);
		int limit = lisp.list.size();
//		System.out.println("Test->" + limit);
		for(int idx = 0;idx < limit;idx++){
			Exp temp = lisp.list.get(idx);
			if(temp.type.equals("List")){
				System.out.println("List::");
				test(temp);
			}
			else if(temp.type.equals("Str")){
				System.out.println("Str::");
				System.out.println(temp.symbol);
			}
			else if(temp.type.equals("Float")){
				System.out.println("Float::");
				System.out.println(temp.floatNumber);
			}
		}
		System.out.println("::List End");
	}

}