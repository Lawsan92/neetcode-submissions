/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return true;
        }
        for (int i = 0; i < intervals.size(); i++) {
            for (int j = 0; j < intervals.size(); j++) {
                if (i != j && 
                (intervals.get(i).start >= intervals.get(j).start &&
                 intervals.get(i).start <= intervals.get(j).end - 1 
                 ||
                 intervals.get(i).end <= intervals.get(j).end &&
                 intervals.get(i).end >= intervals.get(j).start + 1
                 )
                 ) {
                    return false;
                }
            }
        }
        return true;
    }
}

/*

* Given an array of meeting time interval objects consisting of start and end times
 `[[start_1,end_1],[start_2,end_2],...], (start_i < end_i)`,
 determine if a person could add all meetings to their schedule without any conflicts.
The intervals may be provided in any order.

* conflicts happen if the a start time of a block falls in the range of any other
 block
   
BRUTE FORCE:
compare every block to every other block
  v
[(0,30),(5,10),(15,20)] 
              v
    [(0,30),(5,10),(15,20)] 5<=0<=20 = false, no conflict

  v
[(0,30),(5,10),(15,20)] 
                     v
    [(0,30),(5,10),(15,20)] 

[(0,8),(8,10)]


*/
