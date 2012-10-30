package com.momock;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import android.os.Environment;

public class Log {
	public static void debug(String log) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(
					Environment.getExternalStorageDirectory() + "/log.txt",
					true));
			pw.println(log);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
