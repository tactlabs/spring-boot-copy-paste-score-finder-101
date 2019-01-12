package org.tact.base.service;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TextFileReader {
	
	public static String FILE_BASE = "D:/test/similarity/";

	public static void main1(String[] args) throws IOException {
		String content = readFile(FILE_BASE + "content2.txt");
		
		System.out.print(content);
	}

	public static String readFile(String fileName) throws IOException {

        RandomAccessFile file = new RandomAccessFile(fileName, "r");

        FileChannel channel = file.getChannel();

        //System.out.println("File size is: " + channel.size());

        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

        channel.read(buffer);

        buffer.flip();//Restore buffer to position 0 to read it

        //System.out.println("Reading content and printing ... ");
        
        String content = "";

        for (int i = 0; i < channel.size(); i++) {
            //System.out.print((char) buffer.get());
            
            content += ""+(char) buffer.get();
        }

        channel.close();
        file.close();
        
        return content;
    }
}
