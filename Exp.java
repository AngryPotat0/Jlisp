import java.util.List;

public class Exp{
	public int intNumber;
	public double floatNumber;
	public String symbol;
	public List<Exp> list;
	public boolean bool;
	String type;
	public void setVal(Exp val){
		this.type = val.type;
		if(val.type.equals("Float"))
		{
			this.floatNumber = val.floatNumber;
		}
		else if(val.type.equals("Int"))
		{
			this.intNumber = val.intNumber;
		}
		else if(val.type.equals("List"))
		{
			this.list = val.list;
		}
		else if(val.type.equals("Bool"))
		{
			this.bool = val.bool;
		}
	}
}