package elberger.shabbatinfo;

import java.util.List;
import java.util.stream.Stream;

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

	public void requestShabbatInfoFeed(Call<ShabbatInfoFeedModel> call, JTextComponent candles, JTextComponent parsha,
			JTextComponent havdallah) 
	{
		call.enqueue(new Callback<ShabbatInfoFeedModel>()
		{
			@Override
			public void onResponse(Call<ShabbatInfoFeedModel> call, Response<ShabbatInfoFeedModel> response)
			{
				ShabbatInfoFeedModel feed = response.body();

				showShabbatInfo(feed, candles, parsha, havdallah);
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
		requestShabbatInfoFeed(service.useZip(view.getUserZip()), view.getCandlesTextField(), 
				view.getParshaTextField(), view.getHavdallahTextField());
	}

	private void showShabbatInfo(ShabbatInfoFeedModel feed, JTextComponent candles, JTextComponent parsha, JTextComponent havdallah)
	{
		feed.setCategory("candles");
/*		String candlesString = feed.getItems().get(0).getItems().getCandles();
		
		feed.setCategory("parashat");
		String parshaString = feed.getItems().get(1).getItems().getParsha();
		
		feed.setCategory("havdalah");
		String havdallahString = feed.getItems().get(2).getItems().getHavdallah();	*/	
		
		candles.setText("test");
/*		parsha.setText(parshaString);
		havdallah.setText(havdallahString);*/
	}
}
