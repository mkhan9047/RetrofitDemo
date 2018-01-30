package com.example.mujahid.retrofitdemo.GithubApi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mujahid on 1/30/2018.
 */

public class GithubRepo {
 private String name;

    public RepoOwner getOwner() {
        return owner;
    }

    private RepoOwner owner;

    public GithubRepo(String name, RepoOwner owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }

     static class RepoOwner {
        @SerializedName("avatar_url")
        private  String image_url;

        public  String getImage_url() {
            return image_url;
        }
    }
}
