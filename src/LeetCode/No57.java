package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class No57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval interval: intervals) {
            if (interval.end < newInterval.start) {
                res.add(interval);
                continue;
            }
            if (newInterval.start >= interval.start) {

            }
        }

        return res;
    }

    public List<Interval> insertMy(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) return intervals;
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start)
                    return 1;
                else if (o1.start < o2.start)
                    return -1;
                else
                    return 0;
            }
        });

        Interval currentRes = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (Interval interval: intervals) {
            if (interval.start <= currentRes.end) {
                if (interval.end > currentRes.end) {
                    currentRes.end = interval.end;
                }
            }
            else {
                res.add(new Interval(currentRes.start, currentRes.end));
                currentRes.start = interval.start;
                currentRes.end = interval.end;
            }
        }
        res.add(new Interval(currentRes.start, currentRes.end));
        return res;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 4));
        intervals.add(new Interval(4, 5));
        intervals.add(new Interval(3, 6));
        intervals.add(new Interval(7, 9));
        for (Interval interval: new No57().insert(intervals, new Interval(5, 8)))
            System.out.println(interval.start + "\t" + interval.end);
    }
}
