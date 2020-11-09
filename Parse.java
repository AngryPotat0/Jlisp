import java.util.ArrayList;

public class Parse{
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
//			float n = Float.parseFloat(token);
			double n = Double.parseDouble(token);
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