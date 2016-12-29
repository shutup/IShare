package com.shutup.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Tom on 12/2/16.
 */
public class ShareItem {
    @NotNull
    private String shareText;
    private String identifier;

    public ShareItem() {

    }

    public ShareItem(String shareText, String identifier) {
        this.shareText = shareText;
        this.identifier = identifier;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
