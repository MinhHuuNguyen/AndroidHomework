package com.example.minh.contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minh on 9/23/2016.
 */
public class Contact implements Serializable {
    private String name;
    private String  mobile;
    private String website;

    private static List<Contact> contactList;
    public static List<Contact> getContactList(){
        if(contactList == null){
            contactList = new ArrayList<>();
            contactList.add(new Contact("FPT Software", "0473007575", "https://www.fpt-software.com"));
            contactList.add(new Contact("EWay", "+84432595450", "https://eway.vn"));
            contactList.add(new Contact("KMS", "+84838486888", "http://www.kms-technology.com"));
            contactList.add(new Contact("BraveBits", " +84463260066", "http://www.bravebits.vn"));
            contactList.add(new Contact("TechKids", "+841653005670", "http://techkids.vn"));
        }
        return contactList;
    }

    public Contact(String name, String mobile, String website) {
        this.name = name;
        this.website = website;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
