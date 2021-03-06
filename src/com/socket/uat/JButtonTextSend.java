package com.socket.uat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JButtonTextSend extends JFrame{
	final JTextField jTextField;
	final JButton jb2;
	long delay = 10;
	public JButtonTextSend(){
		String sleep = DataSender.getRfidTxt(DataSender.SLEEP);
        if(sleep==null){
        	sleep = "10";
        }
        try {
        	delay = Long.parseLong(sleep);
		} catch (Exception e) {
			delay = 10;
		}
		
		URL url=JButtonTextSend.class.getResource("go.png");
//		Icon icon=new ImageIcon(url);//实例化Icon对象
		int width = 500,height = 500;
		ImageIcon image = new ImageIcon(url);
		image.setImage(image.getImage().getScaledInstance(width/5,height/5,Image.SCALE_DEFAULT));
		
		//设置网格布局管理器   3行2列  水平5垂直5
        setLayout(new GridLayout(2,2,5,5));
        //创建容器
        Container container=getContentPane();
        
        jTextField = new JTextField();
        jTextField.setBounds(new Rectangle(200,50,200,50));
        container.add(jTextField);
        
        jb2=new JButton("点击发送("+delay+"s)");//实例化一个没有文字与图片的按钮
        jb2.setMaximumSize(new Dimension(90,30));//设置按钮和图片的大小相同
        jb2.setIcon(image);//为按钮设置图标
        jb2.setHideActionText(true);
        jb2.setToolTipText("点我一次,"+delay+"s后才可以点哦");//设置按钮提示为文字
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String mesg = jTextField.getText().trim();
            	if(mesg!=null && mesg.length()>0){
            		actionPerformedTask(mesg.trim());
            	}
            }
        });
        container.add(jb2);//将按钮添加到容器中
        
        jTextField.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent arg0){
        		String mesg = jTextField.getText().trim();
            	if(mesg!=null && mesg.length()>0){
            		actionPerformedTask(mesg.trim());
            	}
        	}
        });
        String sendPort = DataSender.getRfidTxt(DataSender.PORT);
		String sendIp = DataSender.getRfidTxt(DataSender.IP);
        setTitle("发送模拟器("+sendIp+":"+sendPort+")");//设置窗口标题
        setVisible(true);//设置窗口可视化
        setSize(width,height);//设置窗口的大小
        ImageIcon icon=new ImageIcon("timg.jpg");
        setIconImage(icon.getImage());  
        //设置窗口的关闭方式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	private void actionPerformedTask(String mesg){
		DataSender.sendPort(mesg.trim());
//		System.out.println("=="+mesg.trim());
		jTextField.setText(null);
		jb2.setEnabled(false);
		jTextField.setEnabled(false);
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				jb2.setEnabled(true);
				jTextField.setEnabled(true);
			}
			}, delay*1000);
		timer = null;
	}

//	public static void main(String[] args) {
//		new JButtonTextSend();
//	}
}
