package com.btechprojects.journalapp.controller;


import com.btechprojects.journalapp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();


    @GetMapping
    public List<JournalEntry> getAll(){         //localhost:8080/journal    GET
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){                  //localhost:8080/journal   POST
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    //get data through 1 id
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    //for delete
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }
}
