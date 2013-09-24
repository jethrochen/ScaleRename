import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class ScaleRename extends JFrame {

	private JLabel labelPath, labelPre, labelSub;
	private JTextField textPath, textPre, textSub;
	private JButton buttonRename, buttonCancel;
	private String path, prefix, subfix, filelist[];
	private File dir;
	
	public ScaleRename()
	{
		super("ScaleRename");
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		labelPath = new JLabel("Input directory");
		container.add(labelPath);
		
		textPath = new JTextField(50);
		container.add(textPath);
		
		labelPre = new JLabel("Input public prefix");
		container.add(labelPre);
		
		textPre = new JTextField(50);
		container.add(textPre);
		
		labelSub = new JLabel("Input public subfix");
		container.add(labelSub);
		
		textSub = new JTextField(50);
		container.add(textSub);
		
		ButtonHandler buttonHandler = new ButtonHandler();
		
		buttonRename = new JButton("Rename");
		container.add(buttonRename);
		buttonRename.addActionListener(buttonHandler);
		
		buttonCancel = new JButton("Cancel");
		container.add(buttonCancel);
		buttonCancel.addActionListener(buttonHandler);
		
		setSize(600, 400);
		setVisible(true);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == buttonCancel) {
				System.out.println("Rename Canceled\n");
			}
			else if (event.getSource() == buttonRename) {
				path = textPath.getText();
				prefix = textPre.getText();
				subfix = textSub.getText();
				
				dir = new File(path);
				filelist = dir.list();
				for (int i = 0; i < filelist.length; i++) {
					System.out.println(filelist[i]);
				}
			}
		}
	}
	
	public static void main(String argc[]) {
		ScaleRename scaleRename = new ScaleRename();
		scaleRename.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
