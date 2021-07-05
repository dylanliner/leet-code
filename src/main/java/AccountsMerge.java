import java.util.*;

public class AccountsMerge {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("David", "David0@m.co", "David1@m.co"));
        accounts.add(Arrays.asList("David", "David3@m.co", "David4@m.co"));
        accounts.add(Arrays.asList("David", "David4@m.co", "David5@m.co"));
        accounts.add(Arrays.asList("David", "David2@m.co", "David3@m.co"));
        accounts.add(Arrays.asList("David", "David1@m.co", "David2@m.co"));


        List<List<String>> accounts2 = new ArrayList<>();
        accounts2.add(Arrays.asList("Hanzo", "Hanzo2@m.co", "Hanzo3@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo4@m.co", "Hanzo5@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo0@m.co", "Hanzo1@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo3@m.co", "Hanzo4@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo7@m.co", "Hanzo8@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo1@m.co", "Hanzo2@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo6@m.co", "Hanzo7@m.co"));
        accounts2.add(Arrays.asList("Hanzo", "Hanzo5@m.co", "Hanzo6@m.co"));

        System.out.println(accountsMerge2(accounts2));
    }



    public static List<List<String>> accountsMerge2(List<List<String>> accounts) {
        //Build graph
        HashMap<String, Set<String>> graph = new HashMap<>();
        HashMap<String, String> mapEmailToName = new HashMap<>();

        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!graph.containsKey(email)) {
                    graph.put(email, new HashSet<>());
                }
                graph.get(email).add(account.get(1));
                mapEmailToName.put(account.get(i), account.get(0));
            }
            if (!graph.containsKey(account.get(1))) {
                graph.put(account.get(1), new HashSet<>());
            }
            graph.get(account.get(1)).addAll(account.subList(1, account.size()));

        }

        //BFS
        Stack<String> stack = new Stack<>();
        List<List<String>> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        graph.forEach((String key, Set<String> node) -> {
            Iterator<String> it = node.iterator();
            String email = it.next();
            if (!visited.contains(email)) {
                List<String> ansAccount = new ArrayList<>();
                List<String> mergedAccount = new ArrayList<>();
                stack.addAll(node);
                ansAccount.add(mapEmailToName.get(email));

                while (!stack.isEmpty()) {
                    String a = stack.pop();
                    if (!visited.contains(a)) {
                        visited.add(a);
                        mergedAccount.add(a);
                        Set<String> neighbors = graph.get(a);
                        for (String neighbor : neighbors) {
                            if (!visited.contains(neighbor)) {
                                stack.addAll(neighbors);
                            }
                        }

                    }

                }
                Collections.sort(mergedAccount);
                ansAccount.addAll(mergedAccount);
                ans.add(ansAccount);
            }


        });


        return ans;

    }
}
