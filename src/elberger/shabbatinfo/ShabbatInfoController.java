package elberger.shabbatinfo;

import java.util.List;
import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShabbatInfoController
{
	private ShabbatInfoView view;
	private ShabbatInfoService service;

	public ShabbatInfoController(ShabbatInfoView view, ShabbatInfoService service)
	{
		this.view = view;
		this.service = service;
	}

	public void requestShabbatInfoFeed(Call<ShabbatInfoFeedModel> call, JTextComponent location, JTextComponent candles,  
										JTextComponent parashat, JTextComponent havdalah) 
	{
		call.enqueue(new Callback<ShabbatInfoFeedModel>()
		{
			@Override
			public void onResponse(Call<ShabbatInfoFeedModel> call, Response<ShabbatInfoFeedModel> response)
			{
				ShabbatInfoFeedModel feed = response.body();

				showShabbatInfo(feed, location, candles, parashat, havdalah);
			}

			@Override
			public void onFailure(Call<ShabbatInfoFeedModel> call, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}

	public void requestShabbatInfo()
	{
		requestShabbatInfoFeed(service.useZip(view.getUserZip()), view.getLocationTextField(), view.getCandlesTextField(),
								view.getParashatTextField(), view.getHavdalahTextField());
	}

	void showShabbatInfo(ShabbatInfoFeedModel feed, JTextComponent locationTextField, JTextComponent candlesTextField, 
						JTextComponent parashatTextField, JTextComponent havdalahTextField)
	{
		List<ShabbatInfoItems> info = feed.getItems();
		
		locationTextField.setText(feed.getTitle());
		
		
		if(info.get(0).getCategory().equals("candles"))
		{
			candlesTextField.setText(info.get(0).getTitle());
		}
		if(info.get(1).getCategory().equals("parashat"))
		{
			parashatTextField.setText(info.get(1).getTitle());
		}
		if(info.get(2).getCategory().equals("havdalah"))
		{
			havdalahTextField.setText(info.get(2).getTitle());
		}
		
	}
}
