package com.example.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeFreeTime {

    class SortInterval implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if(o1.start==o2.start) {
                return o2.end - o1.end;
            }

            return o1.start - o2.start;
        }
    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        List<Interval> sol = new ArrayList<>();
        for(int i=0; i<schedule.size(); i++) {
            intervals.addAll(schedule.get(i));
        }

        Collections.sort(intervals, new SortInterval());
        if(intervals.size()==0)
            return sol;
        Interval temp = intervals.get(0), tempp;

        for(int i=1; i<intervals.size(); i++) {
            tempp = intervals.get(i);
            if(intervalMerge(temp, intervals.get(i))) {
                temp.start = Integer.min(temp.start, tempp.start);
                temp.end = Integer.max(temp.end, tempp.end);
            } else {
                if(temp.end-intervals.get(i).start !=0)
                    sol.add(new Interval(temp.end, tempp.start));
                temp = intervals.get(i);
            }
        }
        return sol;
    }

    boolean intervalMerge(Interval temp, Interval tempp) {
        if(temp.end <= tempp.start) {
            return false;
        }
        if(temp.start >= tempp.end) {
            return false;
        }
        return true;
    }
}
