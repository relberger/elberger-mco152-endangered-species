package elberger.shabbatinfo;

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
		ShabbatInfo candlesInfo = feed.getItems().get(0);
		String candlesString = candlesInfo.getItems().getCandles();
		
		ShabbatInfo parshaInfo = feed.getItems().get(1);
		String parshaString = parshaInfo.getItems().getParsha();
		
		ShabbatInfo havdallahInfo = feed.getItems().get(2);
		String havdallahString = havdallahInfo.getItems().getHavdallah();		
		
		candles.setText(candlesString);
		parsha.setText(parshaString);
		havdallah.setText(havdallahString);
	}
}
