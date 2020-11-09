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
			System.out.print("Lisp>");
			String program = cin.nextLine();
			if(program.equals("exit"))
			{
				break;
			}
			Exp lispProgram = Parse.parse(program);
//			System.out.println(lispProgram);
//			test(lispProgram);
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
		if(lisp == null)
		{
			System.out.println("NULL>>>>");
		}
		if(lisp.type.equals("List")){
			int limit = lisp.list.size();
			for(int idx = 0;idx < limit;idx++) {
				Exp temp = lisp.list.get(idx);
				if (temp.type.equals("List")) {
//					System.out.println("List::");
					test(temp);
				}
				else if(temp.type.equals("Str")){
//					System.out.println("Str::");
					System.out.println(temp.symbol);
				}
				else if(temp.type.equals("Float")){
//					System.out.println("Float::");
					System.out.println(temp.floatNumber);
				}
			}
		}
		if(lisp.type.equals("Str")){
//			System.out.println("Str::");
			System.out.println(lisp.symbol);
		}
		if(lisp.type.equals("Float")){
//			System.out.println("Float::");
			System.out.println(lisp.floatNumber);
		}
	}
//		System.out.println("::List End");
	}