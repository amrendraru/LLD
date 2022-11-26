import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        P2PFileSystem p2PFileSystem = new P2PFileSystem();
        List<Integer> chunkIds = new ArrayList<>();
        chunkIds.add(1);
        chunkIds.add(3);
        chunkIds.add(4);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.leave(1);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.leave(2);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.join(chunkIds);
        p2PFileSystem.join(chunkIds);

        TreeSet<Integer> userIds = p2PFileSystem.request(1);
        System.out.println(userIds);
    }
}
