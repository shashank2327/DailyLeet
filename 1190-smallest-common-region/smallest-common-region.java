class Solution {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        
        Map<String, String> childToParent = new HashMap<>();

        for (List<String> region : regions) {
            String parent = region.get(0);
            for (int i = 1; i < region.size(); i++) {
                childToParent.put(region.get(i), parent);
            }
        }

        Set<String> set = new HashSet<>();
        while (region1 != null) {
            set.add(region1);
            region1 = childToParent.get(region1);
        }

        while (region2 != null) {
            if (set.contains(region2)) return region2;
            region2 = childToParent.get(region2);
        }

        return null;
    }
}