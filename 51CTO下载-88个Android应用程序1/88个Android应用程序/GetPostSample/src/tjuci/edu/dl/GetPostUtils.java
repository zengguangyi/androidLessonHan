package tjuci.edu.dl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;

public class GetPostUtils {
	public static String sendGet(String url, String params) {
		String urlName = url + "?" + params;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		try {
			URL realURL = new URL(urlName);
			URLConnection conn = realURL.openConnection();
			conn.connect();
			br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	public static String sendPost(String url, String params) {
		StringBuffer sb = new StringBuffer();
		PrintStream ps = null;
		BufferedReader br = null;
		try {
			URL realURL = new URL(url);
			URLConnection conn = realURL.openConnection();
			// 发送post必须设置这两行
			conn.setDoInput(true);
			conn.setDoOutput(true);
			ps = new PrintStream(conn.getOutputStream());
			ps.print(params);// 发送参数
			ps.flush();
			br = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
