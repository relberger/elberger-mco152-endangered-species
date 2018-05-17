package elberger.shabbatinfo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RequestShabbatInfoFeedTest
{

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void test() throws IOException
	{
		ShabbatInfoView view = new ShabbatInfoView();
		ShabbatInfoService service = Mockito.mock(ShabbatInfoService.class);
		ShabbatInfoController controller = new ShabbatInfoController(view, service);
		ShabbatInfo info = Mockito.mock(ShabbatInfo.class);
		ShabbatInfoFeedModel feed = Mockito.mock(ShabbatInfoFeedModel.class);
		

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://www.hebcal.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();

		service = retrofit.create(ShabbatInfoService.class);
		
		Call<ShabbatInfoFeedModel> call = service.useZip("07208");
		
		//when 
		controller.requestShabbatInfoFeed(call, view.getLocationTextField(), view.getCandlesTextField(), 
											view.getParashatTextField(), view.getHavdalahTextField());

		//then 
		assertEquals("Candle lighting: 7:52pm", feed.getItems().get(0).getTitle());
	}

}
