import java.util.List;
import java.util.TreeSet;

public interface FileSystem {

    Integer join(List<Integer> chunkId);

    TreeSet<Integer> request(Integer userId);

    void leave(Integer userId);
}
