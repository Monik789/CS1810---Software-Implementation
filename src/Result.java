
public class Result<T> {

	private T value;
	private String errorMessage;
	private boolean isGood;
	
	public Result(String s)
	{
		this.errorMessage = s;
		this.isGood = false;
	}
	public Result(T val)
	{
		this.value = val;
		this.isGood = true;		
	}
	public boolean isError() { return !this.isGood;}

	public final String getError() {return this.errorMessage; }
	public T getValue() { return this.value;}
}
