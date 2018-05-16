package elberger.shabbatinfo;

public class ShabbatInfo
{
	
	private String date;
	private String candles;
	private String parashat;
	private String havdalah;
	private ShabbatInfoItems items;
	
	public ShabbatInfo(String category, String title)
	{
		items = new ShabbatInfoItems(date, candles, parashat, havdalah);
	}
	
	public ShabbatInfoItems getItems()
	{
		return items;
	}
}
