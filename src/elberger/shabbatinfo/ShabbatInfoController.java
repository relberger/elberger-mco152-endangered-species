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

	public void requestShabbatInfoFeed(Call<ShabbatInfoFeedModel> call, JTextComponent candles, JTextComponent parashat, 
			                           JTextComponent havdalah) 
	{
		call.enqueue(new Callback<ShabbatInfoFeedModel>()
		{
			@Override
			public void onResponse(Call<ShabbatInfoFeedModel> call, Response<ShabbatInfoFeedModel> response)
			{
				ShabbatInfoFeedModel feed = response.body();

				showShabbatInfo(feed, candles, parashat, havdalah);
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
								view.getParashatTextField(), view.getHavdalahTextField());
	}

	void showShabbatInfo(ShabbatInfoFeedModel feed, JTextComponent candlesTextField, JTextComponent parashatTextField,
						JTextComponent havdalahTextField)
	{
		Stream<ShabbatInfo> info = feed.getItems().stream();
		ShabbatInfoItems items = ((ShabbatInfo) info).getInfoItems();
		
		candlesTextField.setText(items.getCandles());
		parashatTextField.setText(items.getParsha());
		havdalahTextField.setText(items.getHavdalah());
		
	}
}
