package floorPlans;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class TextFileReader implements FloorPlanFileReader{
	
	
	
	private int getWidth(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean endsWithoutNewLine = false;
	        while ((readChars = is.read(c)) != -1) {
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    ++count;
	            }
	            endsWithoutNewLine = (c[readChars - 1] != '\n');
	        }
	        if(endsWithoutNewLine) {
	            ++count;
	        } 
	        return count;
	    } finally {
	        is.close();
	    }
	}
	private int getLength(String path) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(path));
		int length = 0;
		length = br.readLine().length();
		br.close();
		return length;
		
	}
	@Override
	public int[][] readFile(String Path) {
		int[][] floorPlan = null ;
		try{
		String file = "src/FloorPlans/testfloorplan.txt";
		int width = getWidth(file);
		int length = getLength(file);
		floorPlan = new int[width][length];
		System.out.println("width: " + floorPlan.length + " length: " + floorPlan[0].length);
		BufferedReader br = new BufferedReader(new FileReader(file));
		for(int i = 0; i < width; i++){
			String line = br.readLine();
			for(int j = 0; j < length; j++){
				floorPlan[i][j] = line.charAt(j)-48;	
			}
		}
	
		br.close();
		return floorPlan;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return floorPlan;
	}

}
