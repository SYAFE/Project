package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {

	public static void main(String[] args) {
		ServerSocket server = null;
		Socket socket = null;
		BufferedReader in, stin;
		BufferedWriter out;
		
		try {
			server = new ServerSocket(9999);
			System.out.println("서버구동중...");
			socket = server.accept();
			System.out.println("연결됨...");
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));  // 소켓으로부터 읽어옴
			stin = new BufferedReader(new InputStreamReader(System.in));  // 키보드로부터 읽어옴
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));  // 소켓으로 보냄
			
			String inMsg;
			while(true) {  // 서버라서 무한루프
				inMsg = in.readLine();
				if(inMsg.equals("bye")) {
					break;
				}
				System.out.println(inMsg);
				String outMsg = stin.readLine();
				out.write("서버>" + outMsg + "\n");
				out.flush();  // 버퍼 안에 있는 정보들을 바로 내보내줌	
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			try {
				socket.close();
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
