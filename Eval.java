public class Eval{
	public static Exp eval(Exp lisp,Env env) {
		if(lisp.type.equals("Float"))
			return lisp;
		else if(lisp.type.equals("List")){
			if(lisp.list.get(0).equals("define")){
                env.setExpMap(lisp.list.get(1),eval(lisp.list.get(2)));
            }
        }
        else if(lisp.type.equals("Str"))
        {
            Calculator proc = env.getEnv(lisp.symbol);
            List<Exp> = new ArrayList<>();
            
        }
		
	}
}