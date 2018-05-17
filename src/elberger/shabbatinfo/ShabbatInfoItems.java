package elberger.shabbatinfo;

public class ShabbatInfoItems
{	
	private String category;
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
}
