package com.example.lxx.atm;



/**
 * Created by lxx on 2017/8/14.
 */

public class UserManager {
    private static int currentUserId;

    public static int getCurrentUserId() {
        return currentUserId;
    }

    public static void setCurrentUserId(int currentUserId) {
        UserManager.currentUserId = currentUserId;
    }





}
