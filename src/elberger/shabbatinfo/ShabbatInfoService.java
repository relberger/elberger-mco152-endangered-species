package elberger.shabbatinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShabbatInfoService
{
	@GET("http://www.hebcal.com/shabbat/?cfg=json&zip=")
	Call<ShabbatInfoFeedModel> useZip(@Query("zip") String userZip);
}
