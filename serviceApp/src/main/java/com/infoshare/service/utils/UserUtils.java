package com.infoshare.service.utils;

import com.infoshare.service.domain.activities.Activity;
import com.infoshare.service.domain.location.Address;
import com.infoshare.service.domain.users.User;
import com.infoshare.service.domain.users.UserDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserUtils {

    public User createUser(UserDTO user) {
        Address address = createAddress(user);
        List<Activity> activities = createActivityList(user);
        return new User(user.getNickname(), user.getMailAddress(), user.getPassword(), user.getBornYear(), user.getPhoneNumber(), user.getGender(), address, activities);
    }

    private Address createAddress(UserDTO user) {
        return new Address(user.getAddress().getTownName(), user.getAddress().getStreetName());
    }

    private List<Activity> createActivityList(UserDTO user) {
        Activity activity = new Activity(user.getSportDiscipline(), user.getActivityLevel());
        return new ArrayList<>(Collections.singletonList(activity));
    }
}
