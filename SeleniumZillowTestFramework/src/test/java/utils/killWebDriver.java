package utils;

import java.io.IOException;

public class killWebDriver {

	public static void main(String[] args) throws IOException {
		kill();
	}
	public static void kill() throws IOException {
		// TODO Auto-generated method stub
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
	}

}
