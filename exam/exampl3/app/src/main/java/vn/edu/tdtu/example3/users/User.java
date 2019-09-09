package vn.edu.tdtu.example3.users;

import java.util.ArrayList;

public class User {
    private String mName;
    private boolean mOnline;

    public User(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<User> createContactsList(int numContacts) {
        ArrayList<User> users = new ArrayList<User>();

        for (int i = 1; i <= numContacts; i++) {
            users.add(new User("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return users;
    }
}