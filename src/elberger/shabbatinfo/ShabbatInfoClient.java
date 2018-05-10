package elberger.shabbatinfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShabbatInfoClient
{
	@GET("http://www.hebcal.com/shabbat/?cfg=json&zip=")
	Call<ShabbatInfoModel> useZip(@Query("zip") String userZip);
}
