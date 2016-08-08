package com.fivelives.net.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtils {
	public static BufferedReader getFileReader(String fileIn)
			throws UnsupportedEncodingException, FileNotFoundException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileIn), "UTF-8"));
		return reader;
	}

	public static BufferedWriter getBufferedWriter(String out) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		return writer;
	}
}
