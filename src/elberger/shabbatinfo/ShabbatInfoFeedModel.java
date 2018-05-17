package elberger.shabbatinfo;

import java.util.List;

public class ShabbatInfoFeedModel
{
	private String category;
	private String title;
	private List<ShabbatInfoItems> items;

	public ShabbatInfoFeedModel(String category, String title, List<ShabbatInfoItems> items)
	{
		super();
		this.category = category;
		this.title = title;
		this.items = items;
	}

	public String getCategory()
	{
		return category;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public List<ShabbatInfoItems> getItems()
	{
		return items;
	}

}
