package com.socket.uat;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class DataSender {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket socket = new Socket("127.0.0.1",8898);
//		OutputStream outputStream = socket.getOutputStream();
//		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
//		bufferedWriter.write("LJ12EKP16E4603874");
//		bufferedWriter.flush();
//		bufferedWriter.close();
//		socket.close();
//		System.out.println("finish send data!!");
//	}
	private static void send(String ip,int port,String mesg) throws UnknownHostException, IOException{
		Socket socket = new Socket(ip,port);
		OutputStream outputStream = socket.getOutputStream();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		bufferedWriter.write(mesg);
		bufferedWriter.flush();
		bufferedWriter.close();
		socket.close();
	}
	public final static String PORT = "port";
	public final static String IP = "ip";
	public final static String SLEEP = "sleep";
	public static void sendPort(String mesg){
		String sendPort = getRfidTxt(PORT);
		String sendIp = getRfidTxt(IP);
		try {
			send(sendIp, Integer.valueOf(sendPort), mesg);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected final static String RFIDTXT = "rfidTxt.properties";
	protected final static String RFIDTXTURL = "rfidSocketTxtUrl";
	public static String getRfidTxt(String keyName){
		String url = "";
		InputStream inputStream = DataSender.class.getClassLoader().getResourceAsStream(RFIDTXT);
		Properties p = new Properties();
		try {
			p.load(inputStream);
			File file = new File(p.getProperty(RFIDTXTURL));
		 	FileInputStream in = null;
	        try{
	            in = new FileInputStream(file);
	            Properties pp = new Properties();
	            pp.load(in);
	            url = pp.getProperty(keyName);
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}
}
