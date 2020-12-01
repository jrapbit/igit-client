package com.jill.gitclient.model._igit;

import lombok.Data;

@Data
public class Permissions {

    private boolean admin;
    private boolean push;
    private boolean pull;


}
