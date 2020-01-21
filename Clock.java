import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

class Clock extends JFrame  
{
	JFrame f;
	private JLabel heading;
	private JLabel clock;
	private Font font1=new Font("Monotype Corsiva",Font.BOLD,40);
	private Font font2=new Font("TRISTAN",Font.BOLD,120);

	Clock()
	{
		f= new JFrame("clock");
		Container c= getContentPane();
		c.setLayout(null);
		Color c1= new Color(221,160,221);
		c.setBackground(c1);

		heading=new JLabel("Digital Clock");
		heading.setBounds(500,10,300,50);
		clock= new JLabel("clock");
		clock.setBounds(400,300,1000,200);
		
		c.add(heading);
		c.add(clock);
		heading.setFont(font1);
		clock.setFont(font2);
		this.startClock();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void startClock()
	{
		Timer timer = new Timer(1000,new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//String dateTime= new Date().toString();
				Date d= new Date();
				SimpleDateFormat sdf= new SimpleDateFormat("hh : mm : ss");
				String dateTime =sdf.format(d);
				clock.setText(dateTime);
			}
		});
		timer.start();
		
	}
	public static void main(String[]args)
	{
		Clock cl=new Clock();
		cl.setSize(300,400);
		cl.setVisible(true);
		cl.setLayout(null);
	}
}