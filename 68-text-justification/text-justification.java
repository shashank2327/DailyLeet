class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> result = new ArrayList<>();

        int[] wordLength = new int[n];
        for (int i = 0; i < n; i++) {
            wordLength[i] = words[i].length();
        }

        int i = 0;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int numberOfCharacters = 0;
            int numberOfWords = 0;
            // maxWidth - numberOfCharacters >= numberOfWords - 1;
            // maxWidth + 1 >= numberOfCharacters + numberOfWords;
            int idx = i;
            while (idx < n) {
                numberOfCharacters += wordLength[idx];
                numberOfWords++;

                if (maxWidth + 1 < numberOfCharacters + numberOfWords) {
                    numberOfCharacters -= wordLength[idx];
                    numberOfWords--;
                    break;
                }
                idx++;
            }

            int extraSpace = maxWidth - numberOfCharacters;
            int spaceLocation = numberOfWords - 1;
            if (spaceLocation == 0) {
                sb.append(words[i]);
                sb.append(" ".repeat(extraSpace));
                result.add(sb.toString());
                i = idx;
                continue;
            }
            // int first = (extraSpace + spaceLocation - 1) / spaceLocation;
            // int second = (extraSpace) / spaceLocation;


            for (int j = i; j < idx; j++) {
                if (idx != n) {
                    sb.append(words[j]);
                    if (spaceLocation > 0) {
                        int first = (extraSpace + spaceLocation - 1) / spaceLocation;
                        sb.append(" ".repeat(first));
                        spaceLocation--;
                        extraSpace -= first;
                    }
                } else {
                    if (j != n - 1) {
                        sb.append(words[j] + " ");
                        extraSpace--;
                    } else {
                        sb.append(words[j]);
                        sb.append(" ".repeat(extraSpace));
                    }
                }
            }
            result.add(sb.toString());
            i = idx;
        }

        return result;
    }
}
// 10;
// 3;  4 4 3

// 10 / 3 = 4;
// 10 / 3 = 3;

// ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do                  "]
// ["Science  is  what we","understand      well","enough to explain to","a  computer.  Art is","everything  else  we","do"]