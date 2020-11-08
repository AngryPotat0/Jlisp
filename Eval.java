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
            if(lisp.list.get(0).equals("define")){
                //FIXME::设置表达式和运算器的问题
                env.setExpMap(lisp.list.get(1).symbol,eval(lisp.list.get(2),env));
            }
            else if(lisp.list.get(0).equals("lambda"))//return a userFunction
            {
                String[] params = new String[lisp.list.get(1).list.size()];
                for(int i = 0;i < lisp.list.get(1).list.size();i++)
                {
                    params[i] = lisp.list.get(1).list.get(i).symbol;
                }
                Exp body = lisp.list.get(2);
                //FIXME::
                env.setMap(lisp.list.get(0).symbol,new userFunction(params,body,env));
            }
            else{
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