package com.example.demo.SampleCombine.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class UserManager {
    private UserManager() {
//        UserManager um = UserManager.getInstance();
//        User u1 = um.createUser("A");
//        User u2 = um.createUser("B");
//
//        Memo m1 = u1.createMemo("レポート提出", "今週までにレポートをまとめ、教授に提出");
//        Memo m2 = u1.createMemo("醤油を買う", "二つ買う");
//
//        Memo m3 = u2.createMemo("定期更新", "通学定期を更新する");
//
//        System.out.println(m1.getTitle() + m2.getTitle() + m3.getTitle());
    }
    private static UserManager instance = null;
    private HashMap<String, User> userHashMap = new HashMap<>();
    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    public Collection<User> getAllUsers() {
        return userHashMap.values();
    }
    public User getUser(String id) {
        return userHashMap.get(id);
    }
    public User createUser(String name) {
        UUID uuid = UUID.randomUUID();
        HashMap<String, Memo> memos = new HashMap<>();
        User user = new User(uuid.toString(), name, memos);
        userHashMap.put(user.getId(), user);
        return user;
    }
    public void deleteUser(String id) {
        userHashMap.remove(id);
    }

    public void setUserHashMap(String id, User user) {
        userHashMap.put(id, user);
    }
}
