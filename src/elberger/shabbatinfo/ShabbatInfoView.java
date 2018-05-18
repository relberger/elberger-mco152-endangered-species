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
	private JLabel parashatLabel;
	private JTextField parashat;
	private JLabel candlesLabel;
	private JTextField candles;
	private JLabel havdalahLabel;
	private JTextField havdalah;

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
		info.setLayout(new GridLayout(4, 2));

		location = new JTextField();
		parashat = new JTextField();
		candles = new JTextField();
		havdalah = new JTextField();

		location.setEditable(false);
		parashat.setEditable(false);
		candles.setEditable(false);
		havdalah.setEditable(false);

		JLabel locationLabel = new JLabel("Shabbat info for this week in:");
		parashatLabel = new JLabel();
		candlesLabel = new JLabel();
		havdalahLabel = new JLabel();

		info.add(locationLabel);
		info.add(location);	
		info.add(parashatLabel);
		info.add(parashat);
		info.add(candlesLabel);
		info.add(candles);
		info.add(havdalahLabel);
		info.add(havdalah);
		panel.add(info, BorderLayout.CENTER);

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
	
	public JLabel getCandlesLabel()
	{
		return candlesLabel;
	}
	
	public JTextComponent getCandlesTextField()
	{
		return candles;
	}
	
	public JLabel getParashatLabel()
	{
		return parashatLabel;
	}


	public JTextComponent getParashatTextField()
	{
		return parashat;
	}
	
	public JLabel getHavdalahLabel()
	{
		return havdalahLabel;
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
