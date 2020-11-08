public class Env{
	private Map<String,calculator> map = new HashMap<>();
	private Map<String,Exp> expMap = new HashMap<>();
	private int i;
	public Env() {
		i = 1;
		map.put("+",new add());
		map.put("-",new sub());
		map.put("*",new mul());

	}
	public Env(String... params,Exp... args) {
		Env();
		for(int i=0;i < params.length;i++){
			expMap.put(params[i],args[i]);
		}
	}
	public Calculator getEnv(String param) {
		//TODO:get Env
		return map.get(param);
	}
	public void setExpMap(String param,Exp exp){
		expMap.put(param,exp);
	}
//	private setMap(String key,)
}