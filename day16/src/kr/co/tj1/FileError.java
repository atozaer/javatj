//package kr.co.tj1;
//
//import java.io.FileWriter;
//import java.io.PrintWriter;
//
//public class FileError {
//	private int[] list;
//
//	private static final SIZE = 10;
//	
//	public FileError() {
//		list = new int[SIZE];
//		for(int i = 0; i<SIZE; i++) {
//			list[i]=i;
//			writeList();
//		}
//	}
//	public void writeList() {
//		PrintWriter out = null;
//
//		out = new PrintWriter(new FileWriter("outfile.txt"));
//		for (int i = 0; i < SIZE; i++)
//		out.println("배열 원소  " + i + " = " + list[i]);
//
//	}
//	public static void main(String[] args) {
//
//	}
//
//}
