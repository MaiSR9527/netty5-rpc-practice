import org.junit.Test;
import org.msr.nio.ByteBufferDemo;

/**
 * author: MaiShuRen
 * site: http://www.maishuren.top
 * since: 2021-03-24 22:02
 **/
public class ByteBufferTest {

    @Test
    public void testByteBufferRead() {
        ByteBufferDemo.readFile("file/file.txt");
    }
}
