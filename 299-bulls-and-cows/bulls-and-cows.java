class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> secretMap = new HashMap<>();
        for (char ch : secret.toCharArray()) {
            secretMap.put(ch, secretMap.getOrDefault(ch, 0) + 1);
        }

        int bullCount = 0;
        int cowCount = 0;

        int len = guess.length();


        // first loop for bull Count
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i) && secretMap.containsKey(secret.charAt(i))) {
                bullCount++;
                secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i)) - 1);
                if (secretMap.get(secret.charAt(i)) == 0) {
                    secretMap.remove(secret.charAt(i));
                }
            }
        }

        // secondL loop for cow count;
        for (int i = 0; i < len; i++) {
            char reqChar = secret.charAt(i);
            char presChar = guess.charAt(i);

            if (reqChar != presChar && secretMap.containsKey(presChar)) { 
                cowCount++;
                secretMap.put(presChar, secretMap.get(presChar) - 1);
                if (secretMap.get(presChar) == 0) {
                    secretMap.remove(presChar);
                }
            }
        }

        
        return bullCount + "A" + cowCount + "B";
    }
}

/*
    1 -> 1
    8 -> 1
*/
/*
    1 -> 2
    2 -> 1
    3 -> 1

*/

/*
    hints ->
    numbers of bulls == number of digits that are at the correct position;
    number of cows == digits that are in the quess but are not in the correct location

    1 8 0 7
    7 8 1 0

    1 1 2 3
    0 1 1 1 
*/