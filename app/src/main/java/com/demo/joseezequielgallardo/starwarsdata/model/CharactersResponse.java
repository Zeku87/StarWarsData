package com.demo.joseezequielgallardo.starwarsdata.model;

import java.util.List;

public class CharactersResponse {
    private int count;
    private String next;
    private String previous;
    private List<Character> results;

    public CharactersResponse(int count, String next, String previous, List<Character> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Character> getResults() {
        return results;
    }
}
