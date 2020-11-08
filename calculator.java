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
	// public Exp userEnv(Exp... args){
	// 	return new Exp(params,args);
    // }
    
    public Exp calculat(Exp[] args){
        return Eval.eval(body,new Env(params,args));
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