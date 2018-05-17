package elberger.shabbatinfo;

public class ShabbatInfo
{
	
	private String category;
	private String title;
	private ShabbatInfoItems items;
	
	public ShabbatInfo(String category, String title)
	{
		items = new ShabbatInfoItems(category, title);
	}
	
	public ShabbatInfoItems getInfoItems()
	{
		return items;
	}
}
