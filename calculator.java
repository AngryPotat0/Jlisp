import java.security.spec.ECParameterSpec;

public interface Calculator{
    Exp calculat(Exp... args);
}

class userFunction implements Calculator{
	private String[] params;
	private Exp body;
	private Env env;
	public userFunction(String[] params,Exp body,Env env){
		this.params = params;
		this.body = body;
		this.env = env;
	}
    
    public Exp calculat(Exp[] args){
        return Eval.eval(body,new Env(params,args,env));
    }
}

class add implements Calculator{
    public Exp calculat(Exp... args){
        Exp res = new Exp();
        res.type = "Float";
        for(Exp i:args){
            res.floatNumber += i.floatNumber;
        }
        return res;
    }
}

class sub implements Calculator{
    public Exp calculat(Exp... args){
        Exp res = new Exp();
        res.type = "Float";
        res.floatNumber = args[0].floatNumber * 2;
        for(Exp i:args){
            res.floatNumber -= i.floatNumber;
        }
        return res;
    }
}

class mul implements Calculator{
    public Exp calculat(Exp... args){
        Exp res = new Exp();
        res.type = "Float";
        res.floatNumber = 1;
        for(Exp i:args){
            res.floatNumber *= i.floatNumber;
        }
        return res;
    }
}

class max implements Calculator{
    public Exp calculat(Exp... args){
        Exp res = new Exp();
        res.type = args[0].type;
        for(Exp arg:args){
            if(res.floatNumber < arg.floatNumber)
            {
                res.floatNumber = arg.floatNumber;
            }
        }
        return res;
    }
}

class min implements Calculator{
    public Exp calculat(Exp... args){
       Exp res = new Exp();
       res.type = args[0].type;
       for(Exp arg:args)
       {
           if(res.floatNumber > arg.floatNumber)
           {
               res.floatNumber = arg.floatNumber;
           }
       }
       return res;
    }
}

class Bt implements Calculator{
    @Override
    public Exp calculat(Exp... args) {
        Exp res = new Exp();
        res.type = "Bool";
        res.bool = args[0].floatNumber > args[1].floatNumber;
        return res;
    }
}

class Lt implements Calculator{
    @Override
    public Exp calculat(Exp... args) {
        Exp res = new Exp();
        res.type = "Bool";
        res.bool = args[0].floatNumber < args[1].floatNumber;
        return res;
    }
}

class sqrt implements Calculator{
    @Override
    public Exp calculat(Exp... args) {
        Exp res = new Exp();
        res.type = "Float";
        res.floatNumber = Math.sqrt((args[0].floatNumber));
        return res;
    }
}