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
	private JTextField location;
	private JTextField parashat;
	private JTextField candles;
	private JTextField havdalah;

	public ShabbatInfoView()
	{
		setTitle("Shabbat Times");
		setSize(400, 145);
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

		JPanel locationInfo = new JPanel();
		locationInfo.setLayout(new GridLayout(1, 2));

		location = new JTextField();
		location.setEditable(false);
		JLabel locationLabel = new JLabel("Shabbat info for this week in:");
		
		locationInfo.add(locationLabel);
		locationInfo.add(location);			
		
		panel.add(locationInfo, BorderLayout.CENTER);
		
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		
		parashat = new JTextField();
		candles = new JTextField();
		havdalah = new JTextField();

		parashat.setEditable(false);
		candles.setEditable(false);
		havdalah.setEditable(false);

		info.add(parashat);
		info.add(candles);
		info.add(havdalah);
		panel.add(info, BorderLayout.SOUTH);

		add(panel);
	
	}

	public String getUserZip()
	{
		return zip.getText();
	}

	public JTextComponent getLocationTextField()
	{
		return location;
	}
	
	public JTextComponent getCandlesTextField()
	{
		return candles;
	}

	public JTextComponent getParashatTextField()
	{
		return parashat;
	}

	public JTextComponent getHavdalahTextField()
	{
		return havdalah;
	}

	public static void main(String[] args)
	{
		new ShabbatInfoView().setVisible(true);
	}
}
