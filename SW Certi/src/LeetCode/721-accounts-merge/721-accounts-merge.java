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

        Map<Integer, TreeSet<String>> users = new HashMap<>();
        for (int i=0; i<accounts.size(); i++) {
            int key = find(i);
            List<String> emails = accounts.get(i);

            users.putIfAbsent(key, new TreeSet<>());  //신규 추가
            users.get(key).addAll(emails.subList(1, emails.size()));    //이름 빼고 합치기
        }

        List<List<String>> result = new LinkedList<>();
        for (Integer key : users.keySet()) {
            String name = accounts.get(key).get(0);
            ArrayList<String> emails = new ArrayList<>(users.get(key));
            emails.add(0, name);
            result.add(emails);
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
    }
}