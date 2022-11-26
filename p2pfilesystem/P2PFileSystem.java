import java.util.*;

public class P2PFileSystem implements FileSystem {

    Map<Integer, TreeSet<Integer>> chunkIdToUser;
    Map<Integer, List<Integer>> userToChunkId;
    int nextUserId;
    PriorityQueue<Integer> availableUserIds;

    public P2PFileSystem() {
        chunkIdToUser = new HashMap<>();
        userToChunkId = new HashMap<>();
        nextUserId = 0;
        availableUserIds = new PriorityQueue<>();
    }

    @Override
    public Integer join(List<Integer> chunkIds) {

        Integer userId = availableUserIds.poll();
        if (userId == null) {
            userId = nextUserId;
            nextUserId++;
        }
        userToChunkId.put(userId, chunkIds);
        Integer finalUserId = userId;
        chunkIds.forEach(chunkId -> {
            if (chunkIdToUser.containsKey(chunkId)) {
                TreeSet<Integer> userIds = chunkIdToUser.get(chunkId);
                userIds.add(finalUserId);
            } else {
                TreeSet<Integer> userIds = new TreeSet<>();
                userIds.add(finalUserId);
                chunkIdToUser.put(chunkId, userIds);
            }
        });


        return userId;
    }

    @Override
    public TreeSet<Integer> request(Integer chunkId) {
        return chunkIdToUser.get(chunkId);
    }

    @Override
    public void leave(Integer userId) {

        availableUserIds.add(userId);
        userToChunkId.remove(userId);
        for (TreeSet<Integer> values : chunkIdToUser.values()) {
            if (values.contains(userId)) {
                values.remove(userId);
            }
        }
    }
}
