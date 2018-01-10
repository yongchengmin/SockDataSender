package com.socket;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Client extends JFrame{
	private	JTextField jTextFieldUser;
	private	JPanel jContentPane;
	private	JLabel jLabelUser;
	private	JButton	jButtonInput;
	
	public Client(){
		this.setSize(806,267);
		this.setLayout(null);
		this.add(getJContentPane());
		this.add(getJTextFieldUser(),null);
		this.add(getJButtonInput(),null);
		this.setVisible(true);
	}
	private JPanel getJContentPane(){
		if(jContentPane == null){
			jLabelUser = new JLabel();
			jLabelUser.setBounds(new Rectangle(15,15,150,15));
			jLabelUser.setText("登录帐号:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelUser,null);
			jContentPane.add(getJTextFieldUser(),null);
			jContentPane.add(getJButtonInput(),null);

		}
		return jContentPane;
	}
	
	private JTextField getJTextFieldUser(){
		if(jTextFieldUser == null){
			jTextFieldUser = new JTextField();
			jTextFieldUser.setBounds(new Rectangle(200,15,200,15));
		}
		return jTextFieldUser;
	}
	
	private JButton getJButtonInput(){
		if(jButtonInput == null){
			jButtonInput = new JButton();
			jButtonInput.setText("输入完成");
			jButtonInput.setSize(new Dimension(100,28));
			jButtonInput.setLocation(new Point(50,350));
			jButtonInput.addActionListener(new java.awt.event.ActionListener(){
				public void actionPerformed(java.awt.event.ActionEvent e){
					String userId = jTextFieldUser.getText().trim();// 获取用户名
					System.out.println(userId);
				}
			});
		}
		return jButtonInput;
	}
	
	
//	public static void main(String[] args) {
//		new Client();
//	}
}
