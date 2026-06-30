class Solution {
    public boolean isValid(String s) {
        // edge case only one paren
        if (s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i) == '(' ) {
                stack.push(s.charAt(i));
                continue;
            }
            // edge case: first character is a closing bracket || all closing brackets
            if (stack.size() == 0) {return false;}

            if(s.charAt(i) == ']' && stack.peek() == '[' || 
               s.charAt(i) == '}' && stack.peek() == '{' ||
               s.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }

        }
        
        return stack.size() == 0;
    }
}

/*

VALID case: "([{}])"

INVALID case: "[(])"

- Every open bracket is closed by the same type of close bracket.
=> the string must have an equal number of closing brakers per opening brakcets 
- Open brackets are closed in the correct order.
=> "correct order" = the most recent open bracket is closed


REQ:

- a way to track the open and closing brackets
- a hashmap wouldn't work because it doesn't track order
- an indexed structure is needed, one that has a begninning and an end

ALGO: 
while traversing the string
    append each opening bracket to a queue
    pop each opening bracket from the queue when encountering its correct closing type bracket
    if the latest closing bracket doesn't match the latest opening bracket
        the parentheses are INVALID
if the list is empty
    the parentheses are valid




["("]

 v
"([{}])"

["(", "["]

  v
"([{}])"

["(", "[", "{"]

   v
"([{}])"


*/