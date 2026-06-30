class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (int c : map.values()) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}


/*
COND
An anagram is a string that contains the exact same characters as another string,
but the order of the characters can be different.

EDGE cases:
the two strings are different lengths -> return false

HIGH level:
we need to verify that both strings have the same character occurrences

ALGO:

v1
pick a string and traverse it
    check if is current character can be found, if it can't
        NOT AN ANAGRAM
completing the traversal == all characters in string 1 were found in string 2
    ANAGRAM

^
FAILS, doesn't count occurrences

v2

an array + 2 pointers?

NON VALID ex:
['b', 'c']
 v
"bbcc"
 v
"ccbc"

[]
  v
"bbcc"
  v
"ccbc"

[c, b]
   v
"bbcc"
   v
"ccbc"

[b, c]
    v
"bbcc"
    v
"ccbc"

VALID ex:

[r, c]
     v              v
s = "racecar", t = "carrace"

[]
       v              v
s = "racecar", t = "carrace"

[e, r]
        v              v
s = "racecar", t = "carrace"

[e, r]
          v              v
s = "racecar", t = "carrace"

[]
          v              v
s = "racecar", t = "carrace"

[]
s = "aaab" t= "abbb"

[]
     v         v
s = "aaab" t= "abbb",  .add() then .remove()

[a, b]
      v         v
s = "aaab" t= "abbb", .add() | .add()

[]
       v         v
s = "aaab" t= "abbb", .add() | .remove()

[]
        v         v
s = "aaab" t= "abbb", .add() | .remove()

FAILS, only tracks parity => need to track count => need

v3
track instances using hashmap

{a: 0}

     v         v         
s = "aaab" t= "abbb",

{a: 1, b: 1}

      v         v         
s = "aaab" t= "abbb",

{a: 3, b: 2}

     ...v      ...v         
s = "aaab" t= "abbb",


{r: 1, c: -1}

   v           v
s="racecar" t="carrace"

{r: 1, c: -1, a: 0}

    v           v
s="racecar" t="carrace"

{r: 0, c: 0, a: 0}

     v           v
s="racecar" t="carrace"

{r: -1, c: 0, a: 0, e: 1}

      v           v
s="racecar" t="carrace"

{r: -1, c: 1, a: -1, e: 1}

       v           v
s="racecar" t="carrace"

{r: -1, c: 0, a: 0, e: 1}

        v           v
s="racecar" t="carrace"

{r: 0, c: 0, a: 0, e: 0}

         v           v
s="racecar" t="carrace"
*/
