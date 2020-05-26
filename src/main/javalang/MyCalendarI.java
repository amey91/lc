package javalang;

import java.util.Map;
import java.util.TreeMap;

// time = logn (for search) + logn (for insert)
// space = n
public class MyCalendarI {
//  https://leetcode.com/problems/my-calendar-i/
//  #729. My Calendar I
    class MyCalendar {
        TreeMap<Integer, Integer> calendar;

        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            // Map.Entry<Integer, Integer> ceiling = calendar.ceilingEntry(start);
            // if (ceiling != null &&  ceiling.getKey() < end) {
            //     return false;
            // }
            // Map.Entry<Integer, Integer> floor = calendar.floorEntry(start);
            // if (floor != null && floor.getValue() > start) {
            //     return false;
            // }

            // instead of checking both, get the entyr whose end is not greater than end
            // which means entry whose bounds are immediately below our window. All other
            // bounds to right of end are greater than end so they are already validated.
            // we
            Map.Entry<Integer, Integer> lower = calendar.lowerEntry(end);
            if (lower == null || lower.getValue() <= start) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }
    }
}
