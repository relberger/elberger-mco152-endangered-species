package elberger.shabbatinfo;

import java.util.List;

import javax.swing.JLabel;
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

	public void requestShabbatInfoFeed(Call<ShabbatInfoFeedModel> call, JTextComponent location, JLabel candlesLabel, JTextComponent candles,  
										JLabel parashatLabel, JTextComponent parashat, JLabel havdalahLabel, JTextComponent havdalah) 
	{
		call.enqueue(new Callback<ShabbatInfoFeedModel>()
		{
			@Override
			public void onResponse(Call<ShabbatInfoFeedModel> call, Response<ShabbatInfoFeedModel> response)
			{
				ShabbatInfoFeedModel feed = response.body();

				showShabbatInfo(feed, location, candlesLabel, candles, parashatLabel, parashat, havdalahLabel, havdalah);
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
		requestShabbatInfoFeed(service.useZip(view.getUserZip()), view.getLocationTextField(), view.getCandlesLabel(),
								view.getCandlesTextField(), view.getParashatLabel(), view.getParashatTextField(), 
								view.getHavdalahLabel(), view.getHavdalahTextField());
	}

	void showShabbatInfo(ShabbatInfoFeedModel feed, JTextComponent locationTextField, JLabel candlesLabel, JTextComponent candlesTextField, 
						JLabel parashatLabel, JTextComponent parashatTextField, JLabel havdalahLabel, JTextComponent havdalahTextField)
	{
		List<ShabbatInfoItems> info = feed.getItems();
		
		locationTextField.setText(feed.getTitle());
		
		
		if(info.get(0).getCategory().equals("candles"))
		{
			String candlesInfo = info.get(0).getTitle();
			String candlesInfoSplit[] = candlesInfo.split(":", 2);
			candlesLabel.setText(candlesInfoSplit[0] + ":");
			candlesTextField.setText(candlesInfoSplit[1]);
		}
		if(info.get(1).getCategory().equals("parashat"))
		{
			String parashatInfo = info.get(1).getTitle();
			String parashatInfoSplit[] = parashatInfo.split(" ", 2);
			parashatLabel.setText(parashatInfoSplit[0] + ":");
			parashatTextField.setText(parashatInfoSplit[1]);
		}
		if(info.get(2).getCategory().equals("havdalah"))
		{
			String havdalahInfo = info.get(2).getTitle();
			String havdalahInfoSplit[] = havdalahInfo.split(" ", 2);
			havdalahLabel.setText(havdalahInfoSplit[0] + ":");
			havdalahTextField.setText(havdalahInfoSplit[1]);
		}
		
	}
}
