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

        System.out.println(accountsMerge(accounts2));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, String> mapOfEmailToPrincipalEmail = new HashMap<>();
        Map<String, String> mapPrincipalEmailToName = new HashMap<>();
        for (List<String> account : accounts) {
            boolean found = false;
            String principalEmail = "";
            for (int i = 1; i < account.size(); i++) {

                if (mapOfEmailToPrincipalEmail.containsKey(account.get(i))) {
                    map.get(mapOfEmailToPrincipalEmail.get(account.get(i))).addAll(account.subList(1, account.size()));
                    principalEmail = mapOfEmailToPrincipalEmail.get(account.get(i));
                    for (int j = 1; j < account.size(); j++) {
                        if (mapOfEmailToPrincipalEmail.containsKey(account.get(j)) && !mapOfEmailToPrincipalEmail.get(account.get(j)).equals(principalEmail)) {
                            map.get(principalEmail).addAll(map.get(mapOfEmailToPrincipalEmail.get(account.get(j))));
                            String toRemove = account.get(j);
                            for (String a : map.get(mapOfEmailToPrincipalEmail.get(toRemove))) {
                                mapOfEmailToPrincipalEmail.put(a, principalEmail);
                            }
                            map.remove(mapOfEmailToPrincipalEmail.get(toRemove));
                            mapPrincipalEmailToName.remove(mapOfEmailToPrincipalEmail.get(toRemove));
                        }
                        mapOfEmailToPrincipalEmail.put(account.get(j), principalEmail);
                    }
                    found = true;
                }

            }
            if (!found) {
                for (int i = 1; i < account.size(); i++) {
                    mapOfEmailToPrincipalEmail.put(account.get(i), account.get(1));
                }
                map.put(account.get(1), new HashSet<>(account.subList(1, account.size())));
                mapPrincipalEmailToName.put(account.get(1), account.get(0));
            }

        }
        List<List<String>> ans = new ArrayList<>();
        mapPrincipalEmailToName.forEach((String principalEmail, String name) -> {
            mapPrincipalEmailToName(principalEmail, name, ans, map);
        });

        return ans;

    }

    private static void mapPrincipalEmailToName(String principalEmail, String name, List<List<String>> ans, Map<String, Set<String>> map) {
        List<String> account = new ArrayList<>();
        account.add(name);
        List<String> emails = new ArrayList<>(map.get(principalEmail));
        Collections.sort(emails);
        account.addAll(emails);
        ans.add(account);
    }
}
