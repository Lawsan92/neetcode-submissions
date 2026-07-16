class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left_ptr = 0;
        int max_count = 0;
        char maj_char = s.charAt(0);
        boolean validWindow = true;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            maj_char = setMajChar(map, maj_char);
            validWindow = lessThanK(map, maj_char, k);
            if (!validWindow) {
              map.put(s.charAt(left_ptr), map.get(s.charAt(left_ptr)) - 1);
              left_ptr ++;
            }
            max_count = Math.max(getMaxCount(map), max_count);
        }
        return max_count;
    }

    public char setMajChar(HashMap<Character, Integer> map, char input_c) {
        char maj_char = input_c;
        for (Character c : map.keySet()) {
            if (map.get(c) > map.get(maj_char))
                maj_char = c;
        }
        return maj_char;
    }

    public boolean lessThanK(HashMap<Character, Integer> map, char maj_c, int k) {
        int sum = 0;
        for (Character c : map.keySet()) {
            if (c != maj_c)
                sum += map.get(c);
        }

        return sum <= k;
    }

    public int getMaxCount(HashMap<Character, Integer> map) {
        int sum = 0;
        for (Character c : map.keySet()) {
            sum += map.get(c);
        }

        return sum;
    }
}
/*

"After performing at most k replacements, return the length of the longest
substring which contains only one distinct character."

ALGORITHMIC conditions
* a majority key must be identified: one key needs a higher count compared to
another key
* the sum of the counts in the minorty key(s) must be less than or equal to k

! What if we have a string composed of only a single character

{A:1}
v
ABBB, k = 2
* maj_key == A{ 1 }
* SUM (count(min_keys)) == 0 (! no minor keys found) <= k -> TRUE
* max_count = SUM(count(all_keys)) == 1

{A:1, B: 1}
 v
ABBB, k = 2
* maj_key == A{ 1 }
* SUM (count(min_keys)) == 1 <= k -> TRUE
* max_count = 2

{A:1, B: 2}
  v
ABBB, k = 2
* maj_key == B{ 2 }
* SUM (count(min_keys)) == 1 <= k -> TRUE
* max_count = 3

{A:1, B: 3}
   v
ABBB, k = 2
* maj_key == B{ 3 }
* SUM (count(min_keys)) == 1 <= k -> TRUE
* max_count = 4

=> RETURN the sum of the counts for all keys (which represents the length of the sub_str)
---------------------------------
{A: 1}
v
AAABABB, k = 1
* maj_key == A { 1 }
* SUM (count(min_keys)) == 0 <= k -> TRUE
* max_count = 1

{A: 2}
v
AAABABB, k = 1
* maj_key == A { 2 }
* SUM (count(min_keys)) == 0 <= k -> TRUE
* max_count = 2

...

{A: 3, B: 1}
   v
AAABABB, k = 1
* maj_key == A { 3 }
* SUM (count(min_keys)) == 1 <= k -> TRUE
* max_count = 4

...

{A: 4, B: 2}
     v
AAABABB, k = 1
* maj_key == A { 4 }
* SUM (count(min_keys)) == 2 <= k -> FALSE
* max_count = 6

follow_up():
  set max_count = sum(count(all_keys)) - 1;
  SLIDE window

*/

/*
{A: 4, B: 2}
v    v
AAABABBBB, k = 1

* maj_key == A { 4 }
* SUM (count(min_keys)) == 2 <= k -> FALSE
* max_count = 6

follow_up():
  set max_count = sum(count(all_keys)) - 1 == 5;
  SLIDE window

{A: 3, B: 3}
 v    v
AAABABBBB, k = 1

{A: 2, B: 4} -> max at 6
  v    v
AAABABBBB, k = 1

{A: 1, B: 5} -> new max at 6
   v    v
AAABABBBB, k = 1

*/