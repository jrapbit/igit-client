package com.jill.gitclient.controller;

import com.jill.gitclient.model.KeywordListResponse;
import com.jill.gitclient.model.ListReposResponse;
import com.jill.gitclient.model._igit.Repo;
import com.jill.gitclient.service.IgitService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@Log4j2
@RestController
@RequestMapping("/api-gogs/v1/repos")
public class ReposController {
    private String token;
    @Autowired
    private IgitService igitService;

    @PostMapping("/token")
    public String getToken(@RequestBody String token){
        this.token = token;
        return "Success";
    }
    @GetMapping("/list")
    public ListReposResponse listRepos() {

        ListReposResponse lstRepos = igitService.getRepos(this.token);
        return lstRepos;
    }
    @GetMapping ("/keyword")
    public List<Repo> listKeywordRepos(@RequestParam("keyword") String keyword){
        KeywordListResponse lstRepos = igitService.getKeywordRepos(token,keyword);
        List<Repo> list = lstRepos.getData();
        return list;
    }
    @GetMapping ("/search")
    public ListReposResponse searchMyRepo (@RequestParam("keyword") String keyword){
        ListReposResponse resultList = igitService.getSearchMyRepo(this.token,keyword);
        return resultList;
    }
    @PostMapping ("/create")
    public Repo createRepo(@RequestBody Map newRepo){
        Repo response = igitService.createRepo(this.token, newRepo);
        return response;


    }

}
