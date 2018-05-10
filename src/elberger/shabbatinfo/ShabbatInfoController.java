package elberger.shabbatinfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class ShabbatInfoController
{
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://www.hebcal.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	
	ShabbatInfoClient service = retrofit.create(ShabbatInfoClient.class);
	String userZip = ShabbatInfoView.zip.getText();
	Call<ShabbatInfoModel> call = service.useZip(userZip);
	
	call.enqueue(new Callback<ShabbatInfoModel>()
	{
		public void onResponse(Call<ShabbatInfoModel> call, Response<ShabbatInfoModel> response)
		{
			ShabbatInfoModel feed = response.body();
		
			ShabbatInfoView.city.setText(feed.getCity());
			ShabbatInfoView.date.setText(feed.getDate());
			ShabbatInfoView.parsha.setText(feed.getParsha());
			ShabbatInfoView.candles.setText(feed.getCandles());
			ShabbatInfoView.havdallah.setText(feed.getHavdallah());			
		}
		
		public void onFailure(Call<ShabbatInfoModel> call, Throwable t)
		{
			t.printStackTrace();
		}
	});

}
