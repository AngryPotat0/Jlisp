public abstract class calculator{
    abstract Exp calculat(Exp... args);
}

class userFunction{
	private String[] params;
	private Exp body;
	private Env env;
	public userFunction(String[] params,Exp body,Env env){
		this.params = params;
		this.body = body;
		this.env = env;
	}
	public Exp call(Exp... args){
		return new Exp();
	}
}

class add extends calculator{
    public Exp calculat(Exp... args){
        Exp res = new Exp();
        res.type = "Float";
        for(Exp i:args){
            res.floatNumber += i.floatNumber;
        }
        return res;
    }
}

class sub extends calculator{
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

class mul extends calculator{
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