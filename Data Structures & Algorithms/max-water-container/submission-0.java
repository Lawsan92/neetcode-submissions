class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int container = 0;
        while (i <= j) {

            int max = Math.max(heights[i], heights[j]);
            int min = Math.min(heights[i], heights[j]);
            if (Math.min(heights[i], heights[j]) * (j - i) > container) {
                container = Math.min(heights[i], heights[j]) * (j - i);
            };
            System.out.println("container: " + container);
            if (max - min > 1) {
                if (min == heights[i]) {
                    i++;
                } else {
                    j--;
                }
            } else {
            i++;
            j--;
            }
        }
        return container;   
    }
}


/*

container = min(left_pillar.height, right_pillar.height) * distance between two pillars

 v             v
[1,7,2,5,4,7,3,6] => 1*7

   v           v              v           v
[1,7,2,5,4,7,3,6] => 7 * 6 | [1,7,2,5,4,7,3,6] => 1*6

     v         v              v          v          
[1,7,2,5,4,7,3,6] => 2 * 5 | [1,7,2,5,4,7,3,6] => 1*4
...

brute force O(n^2): check every combination of pairs

 v v
[1,7,2,5,4,7,3,6]: 1*1
 v   v
[1,7,2,5,4,7,3,6]: 1*2
...
   v v
[1,7,2,5,4,7,3,6]: 2*1
   v v
[1,7,2,5,4,7,3,6]: 5*2
...

redundant values? need to determine
safest check is O(n)
move left pointer about 1/2 way, move the right pointer as well



 v             v
[1,7,2,5,4,7,3,6]: 1*7 = 7

it makes the most sense to move the left pointer
if the min number is 1, and we're at the max length, the container can't get larger as
long as the minimum value is 1

   v           v
[1,7,2,5,4,7,3,6]: 6*6 = 36   

does it make sense to go any further?
it's possible that there are two columns taller than bother vals, creating a new min and max
How do I decide which pointer to move?
moving only the right pointer isn't valid because the new max size is 7*5=35, smaller
it only makes sense to move both

     v       v
[1,7,2,5,4,7,3,6]: 2*4 = 8

it only makes sense to move both pointers, we need a min that's greater than any prev minimum,
which means we need a greater max too

we need to keep track of both the current minimum + current maximum

e.g.

min = 1;
max = 7;


if (min != max - 1) {
    move min
} else {
    move max and min
}

max = 7, min = 1, 

max - min >= distance + 1

        v       v
[1,7,2,1000,999,7,3,6]: 1*7 = 8

*/

/*
v = pillar
x = water

[2,2,2]
  vxvxv
  vxvxv

[1,7,2,5,4,7,3,6]

  vxxxxxxxv
  vxxxxxxxvxxxv
  vxxxxxvxvxxxv
  vxxxvxvxvxxxv      
  vxxxvxvxvxvxv
  vxvxvxvxvxvxv
vxvxvxvxvxvxvxv

CONTAINER:
* how is the smallest exampled created?
    * >= 2 pillars
    * >= 1 height unit for BOTH pillars
    * >= 1 space between the pillars => negigible, spaces are assumed in the array

* how are containers separated?
    * a triplet of pillars need to exist, where the middle pillar is the tallest 
    of the three

    e.g.

    [1,2,1]

      v
    vxvxv = 2 containers of 1

* how are containers merged?
    * a triplet of pillars need to exist, where the middle pillar is the shortest
    of the three

    e.g.

    [2, 1, 2]

    vxxxv
    vxvxv = 1 container of 4


*/
