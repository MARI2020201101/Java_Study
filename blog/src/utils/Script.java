package utils;

public class Script {
	
	public static String back(String msg) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("history.back();");
		sb.append("alert(");
		sb.append(msg);
		sb.append(");</script>");
		return sb.toString();
	}

}
