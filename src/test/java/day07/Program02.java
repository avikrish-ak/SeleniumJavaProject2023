package day07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Program02 {

	public static void main(String[] args) {
		try {
			File src = new File(".\\src\\test\\resources\\Newconfig.properties");
			OutputStream ip = new FileOutputStream(src);
			Properties property = new Properties();
			
			property.setProperty("browser", "firefox");
			property.setProperty("screenshot", "./src/test/");
			
			property.store(ip, "New Property added and updated browser");
			System.out.println(property);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
