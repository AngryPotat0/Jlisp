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

	private static Exp eval(Exp lisp,Env env) {
		if(lisp.type.equals("Float"))
			return lisp;
		else if(lisp.type.equals("List")){
			if(lisp.list.get(0).equals("define")){

			}
		}
		
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

class Exp{
	public int intNumber;
	public float floatNumber;
	public String symbol;
	public List<Exp> list;
	String type;
}

class Env{
	private Map<String,calculator> map = new HashMap<>();
	private int i;
	public Env() {
		i = 1;
		map.put("+",new add());
		map.put("-",new sub());
		map.put("*",new mul());

	}
//	private setMap(String key,)
}

class Parse{
	private static int idx;
	public static Exp parse(String program){
		return readToken(getToken(program));
	}

	private static String[] getToken(String lis){
		idx = 0;
		return lis.replace("(","( ").replace(")"," )").split(" ");
	}

	private static Exp readToken(String[] tokens){
//		while(tokens[idx].equals(""))idx++; 
		if(idx >= tokens.length)
		{
			throw new IllegalArgumentException();
		}
		String token = tokens[idx++];
		Exp e = new Exp();
		if(token.equals("("))
		{
			e.type = "List";
			e.list = new ArrayList<>();
			while(!token.equals(")"))
			{
				e.list.add(readToken(tokens));
				token = tokens[idx];
			}
			idx += 1;
			return e;
		}
		else if(token.equals(")"))
		{
			throw new IllegalArgumentException();
		}
		return exp(token);
	}

	private static Exp exp(String token){
		Exp e = new Exp();
		try{
			float n = Float.parseFloat(token);
			e.type = "Float";
			e.floatNumber = n;
			return e;
		}catch(NumberFormatException s){
			e.type = "Str";
			e.symbol = token;
			return e;
		}
	}

}
