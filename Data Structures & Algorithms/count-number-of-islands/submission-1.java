class Solution {
    public int numIslands(char[][] grid) {
        TreeMap<String, HashSet<String>> map = new TreeMap<String, HashSet<String>>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    if (map.size() < 1) {
                        map.put(map.size() + "", new HashSet<String>(Set.of(x + "|" + y)));
                    } else {
                        int inBucket = 0;
                        String [] dupes = new String[map.size() + 10];
                        for (String i : map.keySet()) {
                            if (map.get(i).contains((x - 1) + "|" + y)
                                || map.get(i).contains((x + 1) + "|" + y)
                                || map.get(i).contains(x + "|" + (y + 1))
                                || map.get(i).contains(x + "|" + (y - 1))) {
                                map.get(i).add(x + "|" + y);
                                inBucket ++;
                                dupes[Integer.parseInt(i)] = i;
                            } 
                        }
                         if (inBucket < 1) {
                            map.put(map.size() + "", new HashSet<String>(Set.of(x + "|" + y)));
                        } else if (inBucket > 1){
                            HashSet<String> merged_bucket = new HashSet<String>();
                            for (int i = 0; i < dupes.length; i++) {
                                if (dupes[i] != null) {
                                    merged_bucket.addAll(map.get(dupes[i]+""));
                                    map.remove(dupes[i]+"");
                                }
                            }
                            map.put(dupes[0]+"", merged_bucket);   
                            // System.out.println(merged_bucket);
                        }
                    }
                }
            }
        }
        // System.out.println("map: " + map.toString());
        return map.size();
    }
}

/*

{ 0|0: 0 }

[[{0, 0}]]

[     v
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]


{ 0|0: 1, 0|1: 0 }

[[{0, 0}, {0, 1}]]

[         v
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]

{ 0|0: 0, 0|1: 0, 0|4: 1 }

[[{0, 0}, {0, 1}], [{0, 4}]]

[                     v
    ["1","1","0","0","1"],
    ["1","1","0","0","1"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
]

loop over matrix
    if the current cell is 1
        add [x, y] coord to map
    if the map contains any neighor cells
        add current coord to pre-existing bucket
    otherwise
        add it to its own, separate bucket
*/

/*

{
    0|1: {bucket_index: 0, rels: [0|2, 0|3]},
    0|2: {bucket_index: 0, rels: [0|1, 0|3]},
    0|3: {bucket_index: 0, rels: [0|1, 0|2]},
    ...
}

[[0|1, 0|2, 0|3]...]

[                 v
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
]

--------------------------------------------------------------------------------------------------------------

{
    0|1: {bucket_index: 0, rels: [0|2, 0|3]},
    0|2: {bucket_index: 0, rels: [0|1, 0|3]},
    0|3: {bucket_index: 0, rels: [0|1, 0|2]},
    1|1: {bucket_index: 0, rels: [0|1]},
    1|3: {bucket_index: 0, rels: [0|3]},
    2|0: {bucket_index: 1, rels: []}
}

[[0|1, 0|2, 0|3, 1|1, 1|3], [2|0]]

[
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
      v
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
]

--------------------------------------------------------------------------------------------------------------

{
    0|1: {bucket_index: 0, rels: [0|2, 0|3]},
    0|2: {bucket_index: 0, rels: [0|1, 0|3]},
    0|3: {bucket_index: 0, rels: [0|1, 0|2]},
    1|1: {bucket_index: 0, rels: [0|1]},
    1|3: {bucket_index: 0, rels: [0|3]},
    2|0: {bucket_index: 1, rels: []}
    2|1: {bucket_index: ?, rels: [1|1, 2|0]} <- MERGE
}

[[0|1, 0|2, 0|3, 1|1, 1|3], [2|0]]

[
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
          v
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
]
--------------------------------------------------------------------------------------------------------------
{
    0: 0|1 -> 0|2 -> 0|3 -> 1|1: -> 1|3,   <- 2|1
    1: 2|0                                 <- 2|1
}

MEGRE():
    check if the current coorinate has neighbors in each set:
        for every set that has neighbors to the current coord:
            save that set's identifier (key = index)
    merge the sets by appending one set to another


{
    0: 0|1 -> 0|2 -> 0|3 -> 1|1 -> 1|3 -> 2|1 -> 2|0
}



[
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
]

*/