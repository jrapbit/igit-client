package com.jill.gitclient.model._igit;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Repo {
    private User owner;
    private Permissions permissions;
    private Integer id;
    private String name;
    private String full_name;
    private String description;

    @JsonAlias("private")
    @JsonProperty("private")
    private Boolean private_project;

    private Boolean fork;
    private Boolean parent;
    private Boolean empty;
    private Boolean mirror;
    private Integer size;
    private String html_url;
    private String ssh_url;
    private String clone_url;
    private String website;
    private Integer stars_count;
    private Integer forks_count;
    private Integer watchers_count;
    private Integer open_issues_count;
    private String default_branch;

    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "Asia/Bangkok")
    private Date created_at;
    private Date updated_at;





    
}
