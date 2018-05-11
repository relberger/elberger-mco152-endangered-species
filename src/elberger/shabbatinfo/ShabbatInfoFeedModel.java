package elberger.shabbatinfo;

import java.util.List;


public class ShabbatInfoFeedModel
{
	private String type;
	private List<ShabbatInfo> items;

	public ShabbatInfoFeedModel(String type, List<ShabbatInfo> items)
	{
		this.type = type;
		this.items = items;
	}
	
	public String getType()
	{
		return type;
	}
	
	public List<ShabbatInfo> getItems()
	{
		return items;
	}
}
