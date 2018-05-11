package elberger.shabbatinfo;

public class ShabbatInfoItems
{
	private String date;
	private String parsha;
	private String candles;
	private String havdallah;
	
	public ShabbatInfoItems(String date, String parsha, String candles, String havdallah)
	{
		super();
		this.date = date;
		this.parsha = parsha;
		this.candles = candles;
		this.havdallah = havdallah;
	}
	public String getDate()
	{
		return date;
	}
	public String getParsha()
	{
		return parsha;
	}
	public String getCandles()
	{
		return candles;
	}
	public String getHavdallah()
	{
		return havdallah;
	}
	
}
