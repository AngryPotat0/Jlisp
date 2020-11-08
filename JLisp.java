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
		while(true){
			System.out.print("JLisp>");
			String program = cin.nextLine();
			Exp lispProgram = Parse.parse(program);
			Exp res = Eval.eval(lispProgram,globalEnv);
			if(res != null){
				test(res);
			}
		}
//		test(res);
		// test(lisp);
//		System.out.println(output(eval(lispProgram,globalEnv)));
		
	}

	private static void test(Exp lisp){
		// System.out.println(lisp.type);
		if(lisp.type.equals("Lisp")){
			int limit = lisp.list.size();
			for(int idx = 0;idx < limit;idx++) {
				Exp temp = lisp.list.get(idx);
				if (temp.type.equals("List")) {
					System.out.println("List::");
					test(temp);
				}
			}
		}
		else if(lisp.type.equals("Str")){
				System.out.println("Str::");
				System.out.println(lisp.symbol);
		}
		else if(lisp.type.equals("Float")){
				System.out.println("Float::");
				System.out.println(lisp.floatNumber);
			}
		}
//		System.out.println("::List End");
	}