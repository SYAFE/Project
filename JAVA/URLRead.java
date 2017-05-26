package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLRead {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.inhatc.ac.kr");
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			
		} catch (MalformedURLException e) {
			System.out.println("URL 오류");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입출력 오류 발생");
			e.printStackTrace();
		}
	}

}
