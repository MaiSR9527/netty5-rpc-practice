package org.msr.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * author: MaiShuRen
 * site: http://www.maishuren.top
 * since: 2021-03-24 22:20
 **/
public class ServerSocketChannelDemo {

    public static void start() {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(8989));
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();

                if (socketChannel != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    int size = socketChannel.read(byteBuffer);
                    while (size > 0) {
                        byteBuffer.flip();
                        Charset charset = StandardCharsets.UTF_8;
                        System.out.println(charset.newDecoder().decode(byteBuffer));
                        size = socketChannel.read(byteBuffer);
                    }
                    byteBuffer.clear();
                    String str = "你好，我已经收到了";
                    ByteBuffer answer = ByteBuffer.wrap(str.getBytes(StandardCharsets.UTF_8));
                    socketChannel.write(answer);
                    answer.clear();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        start();
    }
}
