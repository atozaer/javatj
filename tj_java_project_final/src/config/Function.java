package config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	public static Long createOrderNo (Date now) {
		String str = sdf.format(now) + String.format("%03d", (int)((Math.random() * 999) + 1)); 
	
		return Long.parseLong(str);
	}
}
