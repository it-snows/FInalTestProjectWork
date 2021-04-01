package com.company;

import org.junit.Assert;
import org.junit.Test;

public class LibraryTests {

    @Test
    public void load_recipes(){
        var dl = new DataLibrary();
        var result = dl.load();
        Assert.assertNotNull(result);
    }
}
