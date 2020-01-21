import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.JFileChooser;

class Editor extends JFrame implements ActionListener
{
	JTextArea t;
	JFrame f;
	JLabel l1;
	JMenuBar mb;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7;
	Editor()
	{
		
		f= new JFrame("Text Editor");
		t= new JTextArea(1600,770);
		Font f1= new Font("",Font.PLAIN,16);
		Color c= new Color(0,0,0);
		Color c1= new Color(255,255,255);
		t.setBackground(c);
		t.setForeground(c1);
		
		mb= new JMenuBar();
		m1= new JMenu("File");
		//add menu item to menu
			mi1= new JMenuItem("New");
			mi2= new JMenuItem("Open");
			mi3= new JMenuItem("Save");
		m1.add(mi1);m1.add(mi2);m1.add(mi3);
			mi1.addActionListener(this);
			mi2.addActionListener(this);
			mi3.addActionListener(this);
		m2= new JMenu("Edit");
		//add menu item to menu
			mi4= new JMenuItem("Cut");
			mi5= new JMenuItem("Copy");
			mi6= new JMenuItem("Paste");
		m2.add(mi4);m2.add(mi5);m2.add(mi6);
			mi4.addActionListener(this);
			mi5.addActionListener(this);
			mi6.addActionListener(this);	
		m3= new JMenu("Close");
			mi7= new JMenuItem("Exit");
		m3.add(mi7);
			mi7.addActionListener(this);
		//add menu to menubar
		mb.add(m1);mb.add(m2);mb.add(m3);
		//setting font of menu
		m1.setFont(f1);m2.setFont(f1);m3.setFont(f1);
		//setting font of menu items
		mi1.setFont(f1);mi2.setFont(f1);mi3.setFont(f1);
		mi4.setFont(f1);mi5.setFont(f1);mi6.setFont(f1);
		f.setJMenuBar(mb);

		f.add(t);
		f.setSize(1600,770);
		f.setVisible(true);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
		if(str.equals("Cut"))
		{
			t.cut();
		}
		else if(str.equals("Copy"))
		{
			t.copy();
		}
		else if(str.equals("Paste"))
		{
			t.paste();
		}
		else if(str.equals("New"))
		{
			t.setText("");
		}
		else if(str.equals("Exit"))
		{
			System.exit(0);
		}
		else if(str.equals("Save"))
		{
			try
			{
				/*FileWriter fw= new FileWriter("editor.txt");
				String s=t.getText();
				char ch[]=s.toCharArray();
				for(int i=0;i<ch.length;i++)
				{
					fw.write(ch[i]);
				}
				fw.close();*/
				JFileChooser jfc= new JFileChooser();
				jfc.setDialogTitle("Save a file");
				
				int result=jfc.showSaveDialog(null);
				if(result==jfc.APPROVE_OPTION)
				{
					File file= jfc.getSelectedFile();
					FileOutputStream fos= new FileOutputStream(file);
					fos.write(t.getText().getBytes());
					fos.flush();
					fos.close();
				}
			}
			catch(Exception ex){};
			JOptionPane.showMessageDialog(this,"data saved");
		}
		else if(str.equals("Open"))
		{
			try
			{
				JFileChooser open= new JFileChooser();
				open.setDialogTitle("Open a file");
		
				int result2=open.showOpenDialog(null);
				if(result2==JFileChooser.APPROVE_OPTION)
				{
					File fi= open.getSelectedFile();
					BufferedReader b= new BufferedReader(new FileReader(fi.getPath()));
					String line="";
					String s="";
					while((line=b.readLine())!=null)
					{
						s+=line;
					}
					t.setText(s);
					if(b!=null)
					{
						b.close();
					}
				}
			}
			catch(Exception ex){};
		}
	}
	public static void main(String[]args)
	{
		new Editor();
	}
}