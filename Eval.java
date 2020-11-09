import java.util.ArrayList;
import java.util.List;
public class Eval{
	public static Exp eval(Exp lisp,Env env) {
		if(lisp.type.equals("Float"))
			return lisp;
		else if(lisp.type.equals("Str"))
        {
            return env.getExpMap(lisp.symbol);
        }
		else if(lisp.type.equals("List")){
            if(lisp.list.get(0).symbol.equals("define")){
                int len = lisp.list.size();
//                System.out.println("    Len of List: " + len);
                if(len == 3)
                {
                    env.setExpMap(lisp.list.get(1).symbol,eval(lisp.list.get(2),env));
                }
                else
                {
                    //(define xs (a b c) (a + b + c))
                    String[] params = new String[lisp.list.get(2).list.size()];
                    for(int i = 0;i < lisp.list.get(2).list.size();i++)
                    {
                        params[i] = lisp.list.get(2).list.get(i).symbol;
//                        System.out.println("    prarms: " + params[i]);
                    }
                    Exp body = lisp.list.get(3);
                    env.setMap(lisp.list.get(1).symbol,new userFunction(params,body,env));
                }
//                System.out.println("<<define");
            }
            else if(lisp.list.get(0).symbol.equals("if"))
            {
                //FIXME::
                Exp test = eval(lisp.list.get(1),env);
                Exp res = test.bool ? eval(lisp.list.get(2),env):eval(lisp.list.get(3),env);
                return res;
            }
            else{
//                System.out.println("Function::>");
//                System.out.println(lisp.list.get(0).symbol);
//                System.out.println("<<EndFunction");
                Calculator proc = env.getEnv(lisp.list.get(0).symbol);
                List<Exp> args = new ArrayList<>();
                for(int i = 1; i < lisp.list.size();i++){
                    args.add(eval(lisp.list.get(i),env));
                }
                return proc.calculat(args.toArray(new Exp[args.size()]));//FIXME:
            }
        }
		return null;
	}
}
//
//(define fib (n)
//        (if (< n 2) 1
//                    (+ (fib (- n 1)) (fib (- n 2)))
//        )
//)
