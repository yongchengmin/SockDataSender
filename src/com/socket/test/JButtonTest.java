package com.socket.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class JButtonTest extends JFrame{
	public JButtonTest(){
		URL url=JButtonTest.class.getResource("base.png");
		Icon icon=new ImageIcon(url);//实例化Icon对象
		//设置网格布局管理器   3行2列  水平5垂直5
        setLayout(new GridLayout(3,2,5,5));
        //创建容器
        Container container=getContentPane();
        for(int i=0;i<5;i++){//创建按钮，同时设置按钮文字和图标
            JButton jb=new JButton("button"+i,icon);
            container.add(jb);//将按钮添加到容器中
            if(i%2==0){
                jb.setEnabled(false);//设置其中一些按钮不可用
            }
        }//上下位两种按钮的实例化
        JButton jb2=new JButton();//实例化一个没有文字与图片的按钮
        jb2.setMaximumSize(new Dimension(90,30));//设置按钮和图片的大小相同
        jb2.setIcon(icon);//为按钮设置图标
        jb2.setHideActionText(true);
        jb2.setToolTipText("图片按钮");//设置按钮提示为文字
        jb2.setBorderPainted(false);//设置按钮边界不显示
        jb2.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //弹出对话框
                JOptionPane.showMessageDialog(null, "弹出对话框");
            }
        });
        container.add(jb2);//将按钮添加到容器中
        setTitle("提交按钮组件按钮小试牛刀");//设置窗口标题
        setVisible(true);//设置窗口可视化
        setSize(500,550);//设置窗口的大小
        //设置窗口的关闭方式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
//	public static void main(String[] args) {
//		JButtonTest jb=new JButtonTest();
//	}
}
