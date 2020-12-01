package com.jill.gitclient.service;


import com.jill.gitclient.model.KeywordListResponse;
import com.jill.gitclient.model.ListReposResponse;
import com.jill.gitclient.model._igit.Repo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public class IgitService {
    RestTemplate restTemplate = new RestTemplate();

    public HttpHeaders getHeader(String token){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+token);
        return headers;

    }

    public ListReposResponse getRepos(String token) {
        String url = "https://igit.mfec.co.th/api/v1/user/repos";
        HttpHeaders headers = getHeader(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<ListReposResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ListReposResponse.class);
        return response.getBody();

    }

    public KeywordListResponse getKeywordRepos(String token, String keyword) {
        String url = "https://igit.mfec.co.th/api/v1/repos/search?q="+keyword;
        HttpHeaders headers = getHeader(token);
        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<KeywordListResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, KeywordListResponse.class);
        return response.getBody();

    }

    public ListReposResponse getSearchMyRepo(String token, String keyword) {
        ListReposResponse lstRepos = getRepos(token);
        ListReposResponse resultList = new ListReposResponse();
        for (Repo repo : lstRepos) {
            if (repo.getName().contains(keyword)) {
                resultList.add(repo);
            }
        }
        return resultList;

    }

    public Repo createRepo(String token, Map newRepo){
        String url = "https://igit.mfec.co.th/api/v1/user/repos";
        HttpHeaders headers = getHeader(token);
        HttpEntity<Map> entity = new HttpEntity<>(newRepo,headers);
        ResponseEntity<Repo> response = restTemplate.postForEntity(url,entity, Repo.class);
        return response.getBody();

    }


}