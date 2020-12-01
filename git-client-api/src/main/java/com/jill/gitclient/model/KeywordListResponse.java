package com.jill.gitclient.model;

import com.jill.gitclient.model._igit.Repo;
import lombok.Data;

import java.util.List;
@Data
public class KeywordListResponse{
    private List<Repo> data;
    private Boolean ok;

}
