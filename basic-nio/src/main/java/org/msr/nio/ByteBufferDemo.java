package org.msr.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * author: MaiShuRen
 * site: http://www.maishuren.top
 * since: 2021-03-24 21:51
 **/
public class ByteBufferDemo {

    /**
     * 读取文件到ByteBuffer中。
     *
     * @param file
     */
    public static void readFile(String file) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int size = fileChannel.read(byteBuffer);
            while (size > 0) {
                byteBuffer.flip();
                Charset charset = StandardCharsets.UTF_8;
                System.out.println(charset.newDecoder().decode(byteBuffer).toString());
                // 清空buffer
                byteBuffer.clear();
                size = fileChannel.read(byteBuffer);
            }
            fileChannel.close();
            accessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
