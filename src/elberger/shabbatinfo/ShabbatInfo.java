package elberger.shabbatinfo;

public class ShabbatInfo
{
	private String id;
	private ShabbatInfoItems properties;
	

	public ShabbatInfo(String city, String date, String parsha, String candles, String havdallah)
	{
		properties = new ShabbatInfoItems(city, date, parsha, candles, havdallah);
	}
	public String getId()
	{
		return id;
	}
	public ShabbatInfoItems getProperties()
	{
		return properties;
	}
}
