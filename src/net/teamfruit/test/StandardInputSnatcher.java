package net.teamfruit.test;

import java.io.IOException;
import java.io.InputStream;

public class StandardInputSnatcher extends InputStream {

	private final StringBuilder buffer = new StringBuilder();
	private static String crlf = System.getProperty("line.separator");

	/**
	 * 文字列を入力する。改行は自動的に行う
	 * @param str 入力文字列
	 */
	public void inputln(final String str) {
		this.buffer.append(str).append(crlf);
	}

	@Override
	public int read() throws IOException {
		if (this.buffer.length()==0) {
			return -1;
		}
		final int result = this.buffer.charAt(0);
		this.buffer.deleteCharAt(0);
		return result;
	}
}