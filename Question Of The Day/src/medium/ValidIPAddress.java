package medium;

/**
 * https://leetcode.cn/problems/validate-ip-address/
 */
public class ValidIPAddress {
	public static void main(String[] args) {
		int i = Integer.parseInt("00");
		System.out.println(i);
	}
	public String validIPAddress(String queryIP) {
		if (queryIP.indexOf('.') >= 0) {
			// IPv4
			int last = -1;
			for (int i = 0; i < 4; ++i) {
				int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
				if (cur < 0) {
					return "Neither";
				}
				if (cur - last - 1 < 1 || cur - last - 1 > 3) {
					return "Neither";
				}
				int addr = 0;
				for (int j = last + 1; j < cur; ++j) {
					if (!Character.isDigit(queryIP.charAt(j))) {
						return "Neither";
					}
					addr = addr * 10 + (queryIP.charAt(j) - '0');
				}
				if (addr > 255) {
					return "Neither";
				}
				if (addr > 0 && queryIP.charAt(last + 1) == '0') {
					return "Neither";
				}
				if (addr == 0 && cur - last - 1 > 1) {
					return "Neither";
				}
				last = cur;
			}
			return "IPv4";
		} else {
			// IPv6
			int last = -1;
			for (int i = 0; i < 8; ++i) {
				int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
				if (cur < 0) {
					return "Neither";
				}
				if (cur - last - 1 < 1 || cur - last - 1 > 4) {
					return "Neither";
				}
				for (int j = last + 1; j < cur; ++j) {
					if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
						return "Neither";
					}
				}
				last = cur;
			}
			return "IPv6";
		}
	}

	//正则
	public String solution(String IP) {
		if (IP == null) {
			return "Neither";
		}

		String regex0 = "(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])";
		String regexIPv4 = regex0 + "(\\." + regex0 + "){3}";
		String regex1 = "([\\da-fA-F]{1,4})";
		String regexIPv6 = regex1 + "(:" + regex1 + "){7}";

		String result = "Neither";
		if (IP.matches(regexIPv4)) {
			result = "IPv4";
		} else if (IP.matches(regexIPv6)) {
			result = "IPv6";
		}
		return result;
	}
}
