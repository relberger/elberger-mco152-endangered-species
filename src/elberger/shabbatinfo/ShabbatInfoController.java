package elberger.shabbatinfo;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.text.JTextComponent;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShabbatInfoController
{
	private ShabbatInfoView view;
	private ShabbatInfoService service;

	public ShabbatInfoController(ShabbatInfoView view, ShabbatInfoService service)
	{
		this.view = view;
		this.service = service;
	}

	public void requestShabbatInfoFeed(Call<ShabbatInfoFeedModel> call, String city)
	{
		call.enqueue(new Callback<ShabbatInfoFeedModel>()
		{
			@Override
			public void onResponse(Call<ShabbatInfoFeedModel> call, Response<ShabbatInfoFeedModel> response)
			{
				ShabbatInfoFeedModel feed = response.body();

				//showShabbatInfo(feed);
			}


			@Override
			public void onFailure(Call<ShabbatInfoFeedModel> call, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}

	private void showShabbatInfo(ShabbatInfoFeedModel feed, String city, String date, String parsha, String candles, String havdallah)
	{
		Stream<ShabbatInfo> info = feed.getItems().stream();

		ShabbatInfoProperties properties = info.getClass().;

		String magnitude = String.valueOf(properties.getMag());
		String location = String.valueOf(properties.getPlace());
		magnitudeField.setText(magnitude);
		locationField.setText(location);
	}
}
