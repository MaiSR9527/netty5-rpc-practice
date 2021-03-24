package org.msr.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * author: MaiShuRen
 * site: http://www.maishuren.top
 * since: 2021-03-24 22:28
 **/
public class SocketChannelDemo {
    public static void startClient() {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8989));
            String msg = "你好，请问收到了吗";
            ByteBuffer msgBuffer = ByteBuffer.wrap(msg.getBytes());
            socketChannel.write(msgBuffer);

            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int size = socketChannel.read(byteBuffer);
            while (size > 0) {
                byteBuffer.flip();
                Charset charset = StandardCharsets.UTF_8;
                System.out.println(charset.newDecoder().decode(byteBuffer));
                byteBuffer.clear();
                size = socketChannel.read(byteBuffer);
            }
            msgBuffer.clear();
            byteBuffer.clear();
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        startClient();
    }
}
