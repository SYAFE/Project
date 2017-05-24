package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChat {

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in, stin;
		BufferedWriter out;
		
		try {
			socket = new Socket("localhost", 9999);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // 소켓으로부터 읽어옴
			stin = new BufferedReader(new InputStreamReader(System.in));  // 키보드로부터 읽어옴
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  // 소켓으로 보냄
			
			while(true) {
				String outMsg = stin.readLine();
				if(outMsg.equals("bye")) {
					out.write(outMsg);
					out.flush();
					break;
				}
				out.write("클라이언트>" + outMsg + "\n");
				out.flush();
				
				String inMsg = in.readLine();
				System.out.println(inMsg);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("호스트 오류 : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("입출력 오류 : " + e.getMessage());
		}
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
