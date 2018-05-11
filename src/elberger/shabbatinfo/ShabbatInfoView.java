package elberger.shabbatinfo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.*;

public class ShabbatInfoView extends JFrame
{
	String zipString;
	String cityString;
	String dateString;
	String parshaString;
	String candlesString;
	String havdallahString;
	JButton button;
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
		JTextField zip = new JTextField();
		button = new JButton("Go");
		searchZip.add(enterZip);
		searchZip.add(zip);
		searchZip.add(button);
		
		button.addActionListener(e ->
		{
			//searchZip();
		});

		JPanel info = new JPanel();
		info.setLayout(new GridLayout(5, 2));
		
		JTextField city = new JTextField();
		JTextField date = new JTextField();
		JTextField parsha = new JTextField();
		JTextField candles = new JTextField();
		JTextField havdallah = new JTextField();
		city.setEditable(false);
		date.setEditable(false);
		parsha.setEditable(false);
		candles.setEditable(false);
		havdallah.setEditable(false);

		JLabel cityLabel = new JLabel("Shabbat times in:" + zipString);
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

	public static void main(String[] args)
	{
		new ShabbatInfoView().setVisible(true);
	}
}
