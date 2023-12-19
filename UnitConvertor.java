import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.print.attribute.SetOfIntegerSyntax;
import javax.swing.*;

class Demo extends JFrame implements ActionListener {
	JButton b1;

	Demo() {
		this.setLayout(null);

		b1 = new JButton("Button 1");

		b1.setBounds(130, 05, 100, 50);

		this.add(b1);

		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == b1) {

			JOptionPane.showMessageDialog(this, "Enter a valid Number",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}

public class UnitConvertor extends JFrame {
	JTabbedPane tb = new JTabbedPane();
	JTextField tf1 = new JTextField(20);
	JTextField tf2 = new JTextField(20);
	JTextField tf3 = new JTextField(20);
	JTextField tf4 = new JTextField(20);
	JTextField tf5 = new JTextField(20);
	JTextField tf6 = new JTextField(20);

	JPanel speed = new JPanel();
	JPanel weight = new JPanel();
	JPanel length = new JPanel();
	JPanel data = new JPanel();
	JPanel currency = new JPanel();
	JPanel temperature = new JPanel();

	JButton speed_btn = new JButton("Convert");
	JButton weight_btn = new JButton("Convert");
	JButton length_btn = new JButton("Convert");
	JButton data_btn = new JButton("Convert");
	JButton currency_btn = new JButton("Convert");
	JButton temperature_btn = new JButton("Convert");

	/* --------SPEED------ */

	JLabel speed_lbl1 = new JLabel(" Select Given Unit ");
	JLabel speed_lbl2 = new JLabel(" Select Unit to be converted ");
	JLabel speed_lbl3 = new JLabel(" Enter Input Here - ");
	JLabel speed_show = new JLabel();

	String speed_array1[] = { "Meter /s", "Kilometer /s", "Mile / h" };
	JComboBox<String> speed_cb1 = new JComboBox<>(speed_array1);

	String speed_array2[] = { "Meter/s", "Kilometer /s", "Mile / h" };
	JComboBox<String> speed_cb2 = new JComboBox<>(speed_array2);

	/*---------Temperature--------*/

	JLabel temp_lbl1 = new JLabel(" Enter Input Here - ");
	JLabel temp_lbl2 = new JLabel(" Select Given Unit ");
	JLabel temp_lbl3 = new JLabel(" Select Unit to be converted ");
	JLabel temp_show = new JLabel("Output will be displayed here !");

	String temp_array1[] = { "Celsius", "Kelvin ", "Fehrenheit" };
	JComboBox temp_cb1 = new JComboBox(temp_array1);
	String temp_array2[] = { "Celsius", "Kelvin ", "Fehrenheit" };
	JComboBox temp_cb2 = new JComboBox(temp_array2);

	/* --------weight------ */

	JLabel weight_lbl1 = new JLabel(" Select Given Unit ");
	JLabel weight_lbl2 = new JLabel(" Select Unit to be converted ");
	JLabel weight_lbl3 = new JLabel(" Enter Input Here - ");
	JLabel weight_show = new JLabel();

	String weight_array1[] = { "Gram ", "Kilogram ", "Ton " };
	JComboBox weight_cb1 = new JComboBox(weight_array1);
	String weight_array2[] = { "Gram ", "Kilogram ", "Ton " };
	JComboBox weight_cb2 = new JComboBox(weight_array2);

	/* --------length------ */

	JLabel length_lbl1 = new JLabel(" Select Given Unit ");
	JLabel length_lbl2 = new JLabel(" Select Unit to be converted ");
	JLabel length_lbl3 = new JLabel(" Enter Input Here - ");
	JLabel length_show = new JLabel();

	String length_array1[] = { "Meter", "Centimeter", "Kilometer" };
	JComboBox length_cb1 = new JComboBox(length_array1);
	String length_array2[] = { "Meter", "Centimeter", "Kilometer" };
	JComboBox length_cb2 = new JComboBox(length_array2);

	/* --------data------ */

	JLabel data_lbl1 = new JLabel(" Select Given Unit ");
	JLabel data_lbl2 = new JLabel(" Select Unit to be converted ");
	JLabel data_lbl3 = new JLabel(" Enter Input Here - ");
	JLabel data_show = new JLabel();

	String data_array1[] = { "Megabyte", "Gigabyte", "Terabyte" };
	JComboBox data_cb1 = new JComboBox(data_array1);
	String data_array2[] = { "Megabyte", "Gigabyte", "Terabyte" };
	JComboBox data_cb2 = new JComboBox(data_array2);

	/* --------currency------ */

	JLabel currency_lbl1 = new JLabel(" Select Given Unit ");
	JLabel currency_lbl2 = new JLabel(" Select Unit to be converted ");
	JLabel currency_lbl3 = new JLabel(" Enter Input Here - ");
	JLabel currency_show = new JLabel();

	String currency_array1[] = { "RS", "USD", "YEN" };
	JComboBox currency_cb1 = new JComboBox(currency_array1);
	String currency_array2[] = { "RS", "USD", "YEN" };
	JComboBox currency_cb2 = new JComboBox(currency_array2);

	JFrame f = new JFrame("Unit Convertor");

	UnitConvertor() {

		speed.setLayout(new GridLayout(4, 2));
		speed.add(speed_lbl3);
		tf1.setText("");
		speed.add(tf1);
		speed.add(speed_lbl1);
		speed.add(speed_cb1);
		speed.add(speed_lbl2);
		speed.add(speed_cb2);
		speed.add(speed_btn);
		tb.add(speed, "Speed");
		speed_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value_str = tf1.getText();
				int i = speed_cb1.getSelectedIndex();
				int j = speed_cb2.getSelectedIndex();
				double value_int = Double.parseDouble(value_str);

				if (value_str.isEmpty()) {

					speed_show.setText("Please enter value !");
					speed.add(speed_show);
				} else {
					if (i == 0 && j == 0) {
						speed_show.setText(value_str + " m/s");
						speed.add(speed_show);
					} else if (i == 0 && j == 1) {
						double km_s = value_int / 1000;
						String output = Double.toString(km_s);
						speed_show.setText(output + " km/s ");

						speed.add(speed_show);
					} else if (i == 0 && j == 3) {
						double mile_h = value_int * 2.2369;
						String output = Double.toString(mile_h);
						speed_show.setText(output + " mile/h");
						speed.add(speed_show);

					} else if (i == 1 && j == 0) {
						double m_s = value_int * 1000;
						String output = Double.toString(m_s);
						speed_show.setText(output + " m/s");
						speed.add(speed_show);

					} else if (i == 1 && j == 1) {
						speed_show.setText(value_str + " km/s");
						speed.add(speed_show);
					} else if (i == 1 && j == 3) {
						double mile_h = value_int * 2236.936292;
						String output = Double.toString(mile_h);
						speed_show.setText(output + " mile/h");
						speed.add(speed_show);
					} else if (i == 2 && j == 2) {
						speed_show.setText(value_str + " km/h");
						speed.add(speed_show);

					} else if (i == 3 && j == 0) {
						double m_h = value_int * 0.44;
						String output = Double.toString(m_h);
						speed_show.setText(output + " m/s");
						speed.add(speed_show);

					} else if (i == 3 && j == 1) {
						double m_h = value_int * 0.000447;
						String output = Double.toString(m_h);
						speed_show.setText(output + " km/s");
						speed.add(speed_show);

					} else if (i == 3 && j == 3) {
						speed_show.setText(value_str + "mile/h");
						speed.add(speed_show);

					} else {
						System.out.println("Something Mistaken ! ");
					}

				}
			}

		});

		length.setLayout(new GridLayout(4, 2));
		length.add(length_lbl3);
		tf3.setText("");
		length.add(tf3);
		length.add(length_lbl1);
		length.add(length_cb1);
		length.add(length_lbl2);
		length.add(length_cb2);
		length.add(length_btn);
		tb.add(length, "length");
		length_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value_str = tf3.getText();

				int i = length_cb1.getSelectedIndex();
				int j = length_cb2.getSelectedIndex();
				double value_int = Double.parseDouble(value_str);

				if (value_str.isEmpty()) {
					length_show.setText("Please enter value !");
					length.add(length_show);
				} else {
					if (i == 0 && j == 0) {
						length_show.setText(value_str + " cm");
						length.add(length_show);
					} else if (i == 0 && j == 1) {
						double cm = value_int / 100;
						String output = Double.toString(cm);
						length_show.setText(output + " m");
						length.add(length_show);
					} else if (i == 0 && j == 2) {
						double cm = value_int / 100000;
						String output = Double.toString(cm);
						length_show.setText(output + " km ");
						length.add(length_show);

					} else if (i == 1 && j == 0) {
						double m = value_int * 100;
						String output = Double.toString(m);
						length_show.setText(output + " cm");
						length.add(length_show);

					} else if (i == 1 && j == 1) {
						length_show.setText(value_str + " m");
						length.add(length_show);
					} else if (i == 1 && j == 2) {
						double km = value_int / 1000;
						String output = Double.toString(km);
						length_show.setText(output + " km");
						length.add(length_show);

					}

					else if (i == 2 && j == 0) {
						double cm = ((value_int) * 100000);
						String output = Double.toString(cm);
						length_show.setText(output + " cm");
						length.add(length_show);

					} else if (i == 2 && j == 1) {
						double m = value_int * 1000;
						String output = Double.toString(m);
						length_show.setText(output + " m");
						length.add(length_show);

					} else if (i == 2 && j == 2) {
						length_show.setText(value_str + " km");
						length.add(length_show);

					}

					else {
						System.out.println("Something Mistaken ! ");
					}

				}
			}

		});

		weight.setLayout(new GridLayout(4, 2));
		weight.add(weight_lbl3);
		tf2.setText("");
		weight.add(tf2);
		weight.add(weight_lbl1);
		weight.add(weight_cb1);
		weight.add(weight_lbl2);
		weight.add(weight_cb2);
		weight.add(weight_btn);
		tb.add(weight, "weight");
		weight_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value_str = tf2.getText();

				int i = weight_cb1.getSelectedIndex();
				int j = weight_cb2.getSelectedIndex();
				double value_int = Double.parseDouble(value_str);

				if (value_str.isEmpty()) {
					weight_show.setText("Please enter value !");
					weight.add(weight_show);
				} else {
					if (i == 0 && j == 0) {
						weight_show.setText(value_str + " gram");
						weight.add(weight_show);
					} else if (i == 0 && j == 1) {
						double kg = value_int / 1000;
						String output = Double.toString(kg);
						weight_show.setText(output + " kg ");
						weight.add(weight_show);
					} else if (i == 0 && j == 2) {
						double g = value_int / 1000000;
						String output = Double.toString(g);
						weight_show.setText(output + " ton ");
						weight.add(weight_show);

					} else if (i == 1 && j == 0) {
						double g = value_int * 1000;
						String output = Double.toString(g);
						weight_show.setText(output + " gram");
						weight.add(weight_show);

					} else if (i == 1 && j == 1) {
						weight_show.setText(value_str + " kg");
						weight.add(weight_show);
					} else if (i == 1 && j == 2) {
						double kg = value_int * 1000;
						String output = Double.toString(kg);
						weight_show.setText(output + " ton");
						weight.add(weight_show);

					}

					else if (i == 2 && j == 0) {
						double ton = (value_int * 1000000);
						String output = Double.toString(ton);
						weight_show.setText(output + " ton");
						weight.add(weight_show);

					} else if (i == 2 && j == 1) {
						double ton = value_int * 1000;
						String output = Double.toString(ton);
						weight_show.setText(output + " kilogram");
						weight.add(weight_show);

					} else if (i == 2 && j == 2) {
						weight_show.setText(value_str + " ton");
						weight.add(weight_show);

					}

					else {
						System.out.println("Something Mistaken ! ");
					}

				}
			}

		});

		data.setLayout(new GridLayout(4, 2));
		data.add(data_lbl3);
		tf4.setText("");
		data.add(tf4);
		data.add(data_lbl1);
		data.add(data_cb1);
		data.add(data_lbl2);
		data.add(data_cb2);
		data.add(data_btn);
		tb.add(data, "data");
		data_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value_str = tf4.getText();

				int i = data_cb1.getSelectedIndex();
				int j = data_cb2.getSelectedIndex();
				double value_int = Double.parseDouble(value_str);

				if (value_str.isEmpty()) {
					data_show.setText("Please enter value !");
					data.add(data_show);
				} else {
					if (i == 0 && j == 0) {
						data_show.setText(value_str + " mb");
						data.add(data_show);
					} else if (i == 0 && j == 1) {
						double mb = value_int / 1024;
						String output = Double.toString(mb);
						data_show.setText(output + " gb ");
						data.add(data_show);
					} else if (i == 0 && j == 2) {
						double m_s = value_int / 1000000;
						String output = Double.toString(m_s);
						data_show.setText(output + " tb ");
						data.add(data_show);

					}

					else if (i == 1 && j == 0) {
						double gb = value_int * 1000;
						String output = Double.toString(gb);
						data_show.setText(output + " mb");
						data.add(data_show);

					} else if (i == 1 && j == 1) {
						data_show.setText(value_str + " mb");
						data.add(data_show);
					} else if (i == 1 && j == 2) {
						double gb = value_int / 1000;
						String output = Double.toString(gb);
						data_show.setText(output + " tb");
						data.add(data_show);

					}

					else if (i == 2 && j == 0) {
						double mb = (value_int / 1000000);
						String output = Double.toString(mb);
						data_show.setText(output + " yb");
						data.add(data_show);

					} else if (i == 2 && j == 1) {
						double gb = value_int / 10000;
						String output = Double.toString(gb);
						data_show.setText(output + " gb");
						data.add(data_show);

					} else if (i == 2 && j == 2) {
						data_show.setText(value_str + " tb");
						data.add(data_show);

					} else {
						System.out.println("Something Mistaken ! ");
					}

				}
			}

		});

		currency.setLayout(new GridLayout(4, 2));
		currency.add(currency_lbl3);
		tf5.setText("");
		currency.add(tf5);
		currency.add(currency_lbl1);
		currency.add(currency_cb1);
		currency.add(currency_lbl2);
		currency.add(currency_cb2);
		currency.add(currency_btn);
		tb.add(currency, "currency");
		currency_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value_str = tf5.getText();

				int i = currency_cb1.getSelectedIndex();
				int j = currency_cb2.getSelectedIndex();
				double value_int = Double.parseDouble(value_str);

				if (value_str.isEmpty()) {
					currency_show.setText("Please enter value !");
					currency.add(currency_show);
				} else {
					if (i == 0 && j == 0) {
						currency_show.setText(value_str + " inr");
						currency.add(currency_show);
					} else if (i == 0 && j == 1) {
						double usd = value_int * 0.01352;
						String output = Double.toString(usd);
						currency_show.setText(output + " usd ");
						currency.add(currency_show);
					} else if (i == 0 && j == 2) {
						double yen = value_int * 0.6511;
						String output = Double.toString(yen);
						currency_show.setText(output + " yen ");
						currency.add(currency_show);

					} else if (i == 1 && j == 0) {
						double inr = 74.0 * value_int;
						String output = Double.toString(inr);
						currency_show.setText(output + " inr fine");
						currency.add(currency_show);

					} else if (i == 1 && j == 1) {
						currency_show.setText(value_str + " usd");
						currency.add(currency_show);
					} else if (i == 1 && j == 2) {
						double yen = value_int * 115;
						String output = Double.toString(yen);
						currency_show.setText(output + " yen");
						currency.add(currency_show);

					}

					else if (i == 2 && j == 0) {
						double inr = (value_int * 0.6511);
						String output = Double.toString(inr);
						currency_show.setText(output + " inr");
						currency.add(currency_show);

					} else if (i == 2 && j == 1) {
						double usd = value_int / 115;
						String output = Double.toString(usd);
						currency_show.setText(output + " km/s");
						currency.add(currency_show);

					} else if (i == 2 && j == 2) {
						currency_show.setText(value_str + " yen");
						currency.add(currency_show);

					}

					else {
						System.out.println("Something Mistaken ! ");
					}

				}
			}

		});

		temperature.setLayout(new GridLayout(4, 2));
		temperature.add(temp_lbl1);
		tf6.setText(" ");
		temperature.add(tf6);
		temperature.add(temp_lbl2);
		temperature.add(temp_cb1);
		temperature.add(temp_lbl3);
		temperature.add(temp_cb2);
		temperature.add(temperature_btn);
		temperature.add(temp_show);
		tb.add(temperature, "Temperature");
		temperature_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp_str = tf6.getText();
				Double temp_value = Double.parseDouble(temp_str);
				int i = temp_cb1.getSelectedIndex();
				int j = temp_cb2.getSelectedIndex();

				if (i == 0 && j == 0) {
					temp_show.setText(temp_str + " c");
				} else if (i == 0 && j == 1) {
					Double k = temp_value + 273.15;
					String output = Double.toString(k);
					temp_show.setText(output + " k");
				} else if (i == 0 && j == 2) {
					Double f = (temp_value * 9 / 5) + 32;
					String output = Double.toString(f);
					temp_show.setText(output + " f");
				} else if (i == 1 && j == 0) {
					Double c = temp_value - 273.15;
					String output = Double.toString(c);
					temp_show.setText(output + " c");

				} else if (i == 1 && j == 1) // k to k
				{
					temp_show.setText(temp_str + " k");

				} else if (i == 1 && j == 2) {
					Double f = (temp_value - 273.15) * 9 / 5 + 32;
					String output = Double.toString(f);
					temp_show.setText(output + " f");

				} else if (i == 2 && j == 0) {
					Double c = (temp_value - 32) * 5 / 9;
					String output = Double.toString(c);
					temp_show.setText(output + " c");

				} else if (i == 2 && j == 1) {
					Double k = (temp_value - 32) * 5 / 9 + 273.15;
					String output = Double.toString(k);
					temp_show.setText(output + " k");

				} else if (i == 2 && j == 2) {

					temp_show.setText(temp_str + " f");

				} else {
					System.out.println("Temperature : Something Mistaken !");
				}
			}
		});

		ImageIcon img = new ImageIcon("icon.jpg");
		f.setIconImage(img.getImage());
		f.setDefaultCloseOperation(3);
		f.setContentPane(new JLabel(new ImageIcon("unit-converter23.jpg")));
		f.getContentPane().setBackground(Color.BLACK);
		f.add(tb);
		f.getRootPane().setBorder(BorderFactory.createMatteBorder(8, 4, 4, 4, Color.BLACK));
		f.setResizable(false);
		f.setLayout(new FlowLayout());
		f.setSize(500, 400);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		UnitConvertor u = new UnitConvertor();

	}
}