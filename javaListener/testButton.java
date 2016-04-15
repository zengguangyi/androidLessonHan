import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;
import javax.swing.*;

class MyFrame extends Frame{
	TextField t1;
	JButton b1;
	MyFrame(){
		setLayout(new FlowLayout());
		t1 = new TextField(12);
		b1 = new JButton("hide");
		t1.setText("hi");
		b1.setActionCommand("b1");//为button添加标识
		b1.setBorderPainted(false);
		b1.setPreferredSize(new Dimension(50,30));
		b1.setMargin(new Insets(0,0,0,0));
		add(t1);
		add(b1);
		setBounds(200,200,300,300);//设置按钮样式
		setVisible(true);//可见
		validate();
		
		/*b1点击事件*/
		b1.addActionListener(new ActionListener(){
			int flag = 1;
			public void actionPerformed(ActionEvent e){
				if(e.getActionCommand().equals("b1") && flag==1){
					t1.setVisible(false);
					b1.setText("show");
					flag = 0;					
				}else{
					t1.setVisible(true);
					b1.setText("hide");
					flag = 1;
				}
			}
		});
		/*frame关闭事件*/
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
}
public class testButton {
	public static void main(String args[]){
		MyFrame myframe = new MyFrame();
	}
}