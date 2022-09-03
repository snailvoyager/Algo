class Solution {
    int[] parent;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<accounts.size(); i++) {
            List<String> emailList = accounts.get(i);

            for (int j=1; j<emailList.size(); j++) {
                String s = emailList.get(j);

                if (map.containsKey(s)) {
                    int k = map.get(s);
                    union(k, i, accounts);
                } else {
                    map.put(s, i);
                }
            }
        }

        List<List<String>> result = new LinkedList<>();
        for (List<String> account : accounts) {
            if (account.size() > 0) {
                String name = account.get(0);
                account.remove(0);

                /*Set<String> set = new HashSet<>(account);
                account.clear();
                account.addAll(set);
                Collections.sort(account);
                account.add(0, name);*/

                List<String> distinctList = account.stream()
                        .distinct()
                        .sorted(String::compareTo)
                        .collect(Collectors.toList());
                distinctList.add(0, name);
                
                result.add(distinctList);
            }
        }
        return result;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y, List<List<String>> accounts) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        parent[rootX] = rootY;
        accounts.get(rootX).remove(0);      //remove name;
        accounts.get(rootY).addAll(accounts.get(rootX));
        accounts.get(rootX).clear();
    }
}