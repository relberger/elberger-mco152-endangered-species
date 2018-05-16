package elberger.shabbatinfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShabbatInfoView extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JTextField zip;
	private JTextField city;
	private JTextField date;
	private JTextField parsha;
	private JTextField candles;
	private JTextField havdallah;

	public ShabbatInfoView()
	{
		setTitle("Shabbat Times");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel searchZip = new JPanel();
		searchZip.setLayout(new BoxLayout(searchZip, BoxLayout.X_AXIS));
		panel.add(searchZip, BorderLayout.NORTH);

		JLabel enterZip = new JLabel("Enter your zip code: ");
		zip = new JTextField();
		JButton button = new JButton("Go");
		searchZip.add(enterZip);
		searchZip.add(zip);
		searchZip.add(button);

		button.addActionListener(e ->
		{
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("http://www.hebcal.com")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			
			ShabbatInfoService service = retrofit.create(ShabbatInfoService.class);
				
			ShabbatInfoController controller = new ShabbatInfoController(this, service);
			
			controller.requestShabbatInfo();			
		});

		JPanel info = new JPanel();
		info.setLayout(new GridLayout(5, 2));

		city = new JTextField();
		date = new JTextField();
		parsha = new JTextField();
		candles = new JTextField();
		havdallah = new JTextField();
		city.setEditable(false);
		date.setEditable(false);
		parsha.setEditable(false);
		candles.setEditable(false);
		havdallah.setEditable(false);

		JLabel cityLabel = new JLabel("Shabbat times in:");
		JLabel dateLabel = new JLabel("For the week of:");
		JLabel parshaLabel = new JLabel("Parshat:");
		JLabel candlesLabel = new JLabel("Candle lighting:");
		JLabel havdallahLabel = new JLabel("Havdallah:");

		info.add(cityLabel);
		info.add(city);
		info.add(dateLabel);
		info.add(date);
		info.add(parshaLabel);
		info.add(parsha);
		info.add(candlesLabel);
		info.add(candles);
		info.add(havdallahLabel);
		info.add(havdallah);
		panel.add(info, BorderLayout.CENTER);

		add(panel);
	
	}

	public String getUserZip()
	{
		return zip.getText();
	}

	public JTextComponent getCandlesTextField()
	{
		return candles;
	}

	public JTextComponent getParshaTextField()
	{
		return parsha;
	}

	public JTextComponent getHavdallahTextField()
	{
		return havdallah;
	}

	public static void main(String[] args)
	{
		new ShabbatInfoView().setVisible(true);
	}
}
