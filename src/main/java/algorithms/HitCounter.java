package algorithms;

/**
 * Unfinished.
 * Don't understand the example from leetcode.
 */
public class HitCounter {
    int timeLimit;
    int[] timeArr;
    int lastHitPtr;

    /** Initialize your data structure here. */
    public HitCounter() {
        timeLimit = 300;
        timeArr = new int[timeLimit];
        lastHitPtr = 0;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = (timestamp - 1) % timeLimit;

        timeArr[index] = timeArr[lastHitPtr] + 1;
        lastHitPtr = index;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (timestamp - 1 > timeLimit -1) {
            int index = (timestamp - 1) % timeLimit;
            timeArr[index] = timeArr[lastHitPtr] - 1;
            lastHitPtr = index;

        }
        return timeArr[lastHitPtr];
    }
}
