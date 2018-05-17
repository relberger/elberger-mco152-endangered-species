package elberger.shabbatinfo;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class UseZipTest
{

	@Test
	void testUseZip() throws IOException
	{
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://www.hebcal.com")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		ShabbatInfoService service = retrofit.create(ShabbatInfoService.class);
		
		// when
		Call<ShabbatInfoFeedModel> call = service.useZip("07208");
		Response<ShabbatInfoFeedModel> response = call.execute();

		// then
		assertFalse(response.body().getItems().isEmpty());
	}
}