package elberger.shabbatinfo;

import java.util.List;

public class ShabbatInfoFeedModel
{
	private String category;
	private String title;
	private List<ShabbatInfo> items;

	public ShabbatInfoFeedModel(String category, String title, List<ShabbatInfo> items)
	{
		super();
		this.category = category;
		this.title = title;
		this.items = items;
	}

	public String setCategory(String category)
	{
		return this.category = category;
	}

	public String getCategory()
	{
		return category;
	}

	public String getTitle()
	{
		return title;
	}

	public List<ShabbatInfo> getItems()
	{
		return items;
	}
	

}
