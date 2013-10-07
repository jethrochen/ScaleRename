package scale.rename;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RenameWindow extends JFrame implements ActionListener {
	
	public String dir;
	public String pre;
	public String sub;
	
	public Rename rename;

	Container container;
	JPanel dirPane;
	JPanel prePane;
	JPanel subPane;
	JPanel buttonPane;
	JLabel dirLabel;
	JLabel preLabel;
	JLabel subLabel;
	JTextField dirText;
	JTextField preText;
	JTextField subText;
	JButton cancelButton, renameButton;
		
	public RenameWindow(Rename rename) {
		super("ScaleRename");
		
		this.rename = rename;
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		this.setSize(400, 300);
		this.setLocation((kit.getScreenSize().width-400)/2, (kit.getScreenSize().height-300)/2);
		this.setLayout(null);
		
		container = this.getContentPane();
		dirPane = new JPanel();
		dirPane.setSize(360, 30);
		dirPane.setLocation(20, 20);
		dirPane.setLayout(new GridLayout(1, 2));
		dirLabel = new JLabel("输入要重命名文件所在的目录");
		dirText = new JTextField(40);
		dirPane.add(dirLabel);
		dirPane.add(dirText);
		container.add(dirPane);
		
		prePane = new JPanel();
		prePane.setSize(360, 30);
		prePane.setLocation(20, 70);
		prePane.setLayout(new GridLayout(1, 2));
		preLabel = new JLabel("输入要重命名文件的公共前缀");
		preText = new JTextField(40);
		prePane.add(preLabel);
		prePane.add(preText);
		container.add(prePane);		
	
		subPane = new JPanel();
		subPane.setSize(360, 30);
		subPane.setLocation(20, 120);
		subPane.setLayout(new GridLayout(1, 2));
		subLabel = new JLabel("输入要重命名文件的公共后缀");
		subText = new JTextField(40);
		subPane.add(subLabel);
		subPane.add(subText);
		container.add(subPane);
		
		buttonPane = new JPanel();
		buttonPane.setSize(360, 30);
		buttonPane.setLocation(20, 170);
		buttonPane.setLayout(new GridLayout(1, 2));
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		renameButton = new JButton("Rename");
		renameButton.addActionListener(this);
		buttonPane.add(cancelButton);
		buttonPane.add(renameButton);
		container.add(buttonPane);		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cancelButton) {
			System.out.println("Rename Canceled!");
			this.dispose();
		}
		if (e.getSource() == renameButton) {
			dir = new String(this.dirText.getText());
			System.out.println(dir);
			pre = new String(this.preText.getText());
			System.out.println(pre);
			sub = new String(this.subText.getText());
			System.out.println(sub);
			rename.changeName(this);
			
		}
	}

}
