class TopVotedCandidate {
    
    Map<Integer, Integer> candidateToVote;
    int[] maxVotes;
    int[] tms;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.tms = times;
        candidateToVote = new HashMap<>();
        int n = persons.length;
        maxVotes = new int[n];
        int max = 0;
        int maxCandidate = -1;
        for (int i = 0; i < n; i++) {
            int candidate = persons[i];
            candidateToVote.put(candidate, candidateToVote.getOrDefault(candidate, 0) + 1);
            if (candidateToVote.get(candidate) >= max) {
                max = candidateToVote.get(candidate);
                maxCandidate = candidate;
            }
            maxVotes[i] = maxCandidate;
        }
    }   
    
    public int q(int t) {
        int l = 0;
        int h = maxVotes.length - 1;

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (tms[mid] == t) {
                h = mid;
                break;
            } else if (tms[mid] < t) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return maxVotes[h];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */


 // How much vote a candidate got;
 // What was the the recent time the candidate got the vote;


// candidate -> {countOfVotes, recentTime};
// I will sort all the candidates on the basis on countOfVotes and then on recentTime;

