package leetcode.medium;

import java.util.Optional;

public class UserStats {
    public Optional<Long> getVisitCount() {
        return visitCount;
    }

    public UserStats(Optional<Long> visitCount) {
        this.visitCount = visitCount;
    }

    private Optional<Long> visitCount;

    @Override
    public String toString() {
        return "UserStats{" +
            "visitCount=" + visitCount +
            '}';
    }
}
