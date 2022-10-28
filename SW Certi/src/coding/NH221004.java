package coding;

import java.io.*;
import java.util.*;

public class NH221004 {
    private Map<String, List<String>> contacts;
    private final List<String> emptyList = new ArrayList<>();

    public void load(String fileName) {
        //InputStreamReader ipsr = new InputStreamReader(this.getClass().getResourceAsStream("file.csv"));    //src/main/resources 파일 읽기
        contacts = new HashMap<>();

        try (InputStreamReader ipsr =  new InputStreamReader(new FileInputStream("SW Certi/src/coding/" + fileName));
             BufferedReader br = new BufferedReader(ipsr)
        ) {
            String line = br.readLine();
            while (line != null) {
                String[] arrStr = line.split(",");
                String name = arrStr[0];
                String phoneNumber = arrStr[1];

                /*List<String> phoneList;
                if (contacts.containsKey(name)) {
                    phoneList = contacts.get(name);
                } else {
                    phoneList = new LinkedList<>();
                }
                phoneList.add(phoneNumber);
                contacts.put(name, phoneList);*/

                //키가 없으면 List 만들어서 Map에 put. 있으면 value 리턴 후 add
                contacts.computeIfAbsent(name, key -> new LinkedList<>()).add(phoneNumber);

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findUniqueNameCount() {
        return contacts.size();
    }

    public List<String> findPhoneListByName(String name) {
        /*if (contacts.containsKey(name)) {
            return contacts.get(name);
        } else {
            //return new ArrayList<>();
            return emptyList;
        }*/
        return contacts.getOrDefault(name, emptyList);
    }

    public List<String> findPhoneSortedList() {
        List<String> sortedList = new LinkedList<>();

        List<Map.Entry<String, List<String>>> entryList = new ArrayList<>(contacts.entrySet());
        entryList.sort((obj1, obj2) -> obj2.getValue().size() - obj1.getValue().size());

        for (Map.Entry<String, List<String>> entry : entryList)
            sortedList.add(entry.getKey());

        return sortedList;
    }

    public static void main(String[] args) {
        NH221004 instance = new NH221004();

        instance.load("NH221004.csv");
        System.out.println(instance.findUniqueNameCount());
        System.out.println(instance.findPhoneListByName("HGD"));
        System.out.println(instance.findPhoneListByName("JJJ"));
        System.out.println(instance.findPhoneSortedList());
    }
}
