package elberger.shabbatinfo;

public class ShabbatInfoItems
{
	
	/*private String category;
	private String title;
	
	public ShabbatInfoItems(String category, String title)
	{
		super();
		this.category = category;
		this.title = title;
	}

	public String getCategory()
	{
		return category;
	}

	public String getTitle()
	{
		return title;
	}
	*/
	
	
	private String date;
	private String candles;
	private String parashat;
	private String havdalah;
	
	public ShabbatInfoItems(String date, String candles, String parashat, String havdalah)
	{
		super();
		this.date = date;
		this.parashat = parashat;
		this.candles = candles;
		this.havdalah = havdalah;
	}
	public String getDate()
	{
		return date;
	}
	public String getParsha()
	{
		return parashat;
	}
	public String getCandles()
	{
		return candles;
	}
	public String getHavdalah()
	{
		return havdalah;
	}
	
}
