class Solution {
    static class DisJointSet{
        int[] parent, size;
        DisJointSet(int n){
            parent = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int n){
            if(parent[n] != n){
                parent[n] = findParent(parent[n]);
            }

            return parent[n];
        }

        void unionBySize(int u, int v){
            int ul = findParent(u);
            int vl = findParent(v);

            if(ul == vl) return;
            if(size[ul]< size[vl]){
                parent[ul] = vl;
                size[vl]+=size[ul];
            }else{
                parent[vl] = ul;
                size[ul]+=size[vl];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisJointSet ds = new DisJointSet(n);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                   map.put(mail, i);
                }else{
                    ds.unionBySize(i, map.get(mail));
                }
            }
        }

        List<List<String>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findParent(map.get(mail));
            list.get(node).add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list.get(i).size() == 0) continue;
            String name = accounts.get(i).get(0);
            Collections.sort(list.get(i));

            List<String> temp = new ArrayList<>();
            temp.add(name);
            for(String str: list.get(i)){
                 temp.add(str);
            }
            res.add(new ArrayList<>(temp));
        }

        return res;
    }
}