import java.util.HashMap;
import java.util.Map;

public class Env{
	private Map<String,Calculator> map = new HashMap<>();
	private Map<String,Exp> expMap = new HashMap<>();
	private int i;
	public Env() {
		i = 1;
		map.put("+",new add());
		map.put("-",new sub());
		map.put("*",new mul());

	}
	public Env(String[] params,Exp[] args) {
		this();
		for(int i=0;i < params.length;i++){
			expMap.put(params[i],args[i]);
		}
	}
	public Calculator getEnv(String key) {
		return map.get(key);
	}

	public void setMap(String key,Calculator calcu){
		map.put(key,calcu);
	}

	public void setExpMap(String param,Exp exp){
		expMap.put(param,exp);
	}
	public Exp getExpMap(String key){
		return expMap.get(key);
	}
//	private setMap(String key,)
}