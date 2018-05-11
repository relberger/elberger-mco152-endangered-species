package elberger.shabbatinfo;

public class ShabbatInfo
{
	private ShabbatInfoItems items;
	
	public ShabbatInfo(String date, String parsha, String candles, String havdallah)
	{
		items = new ShabbatInfoItems(date, parsha, candles, havdallah);
	}
	
	public ShabbatInfoItems getItems()
	{
		return items;
	}
}
