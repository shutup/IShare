package com.shutup.controller;

import com.shutup.model.ShareItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Tom on 12/2/16.
 */
@RestController
@RequestMapping("/share")
public class IShareController {

    List<ShareItem> data = new ArrayList<>();


    @RequestMapping(path = {"/text"},method = RequestMethod.POST)
    public ResponseEntity<ShareItem> shareText(@RequestBody ShareItem shareItem) {
        shareItem.setIdentifier(UUID.randomUUID().toString());
        System.out.println(shareItem.getShareText());
        data.add(shareItem);
        return ResponseEntity.ok(shareItem);
    }

    @RequestMapping(path = {"/text"}, method = RequestMethod.GET)
    public ResponseEntity<ShareItem> getShareText(@RequestParam(name = "identifier") String identifier) {
        ShareItem shareItem = new ShareItem();
        for (ShareItem s:
             data) {
            if (s.getIdentifier().equals(identifier)) {
                shareItem = s;
            }
        }
        return ResponseEntity.ok(shareItem);
    }
}
