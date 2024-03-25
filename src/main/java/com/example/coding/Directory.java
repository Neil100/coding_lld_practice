package com.example.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Directory {
    HashMap<String, String> fileMap;
    HashMap<String, Directory> directorMap;

    public Directory() {
        fileMap = new HashMap<>();
        directorMap = new HashMap<>();
    }
}
