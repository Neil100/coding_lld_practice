package com.example.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FileSystem {

    private Directory directory;
    public FileSystem() {
        this.directory = new Directory();
    }

    public List<String> ls(String path) {
        List<String> pathList = Arrays.asList(path.split("/"));

        if(pathList.size()==0)
            return ls(pathList, 0, directory);
        return ls(pathList, 1, directory);
    }

    public void mkdir(String path) {

        List<String> pathList = Arrays.asList(path.split("/"));
        mkdir(pathList, 1, directory);
    }

    public void addContentToFile(String filePath, String content) {
        List<String> pathList = Arrays.asList(filePath.split("/"));

        addContentToFile(pathList, 1, directory, content);
    }

    public String readContentFromFile(String filePath) {
        List<String> pathList = Arrays.asList(filePath.split("/"));

        return readContentFromFile(pathList, 1, directory);
    }

    public List<String> ls(List<String> path, int index, Directory directory) {
        if(index>path.size())
            return Collections.emptyList();
        if(index==path.size()) {
            List<String> keySet = new ArrayList<>();
            keySet.addAll(directory.fileMap.keySet());
            keySet.addAll(directory.directorMap.keySet());
            Collections.sort(keySet);
            return keySet;
        } else if(index==path.size()-1) {
            if(directory.fileMap.containsKey(path.get(index))) {
                return Collections.singletonList(path.get(index));
            }
        }
        if(directory.directorMap.containsKey(path.get(index))) {
            return ls(path, index+1, directory.directorMap.get(path.get(index)));
        }
        return Collections.emptyList();
    }

    public void mkdir(List<String> path, int index, Directory directory) {
        if(index==path.size())
            return;

        if(directory.directorMap.containsKey(path.get(index))) {
            mkdir(path, index+1, directory.directorMap.get(path.get(index)));
        } else {
            Directory newDirectory = new Directory();
            directory.directorMap.put(path.get(index), newDirectory);
            mkdir(path, index+1, directory.directorMap.get(path.get(index)));
        }
    }

    public void addContentToFile(List<String> path, int index, Directory directory, String content) {

        if(index==path.size()-1) {
            if(directory.fileMap.containsKey(path.get(index))) {
                String curContent = directory.fileMap.get(path.get(index));
                String newContent = curContent + content;

                directory.fileMap.put(path.get(index), newContent);
            } else {
                directory.fileMap.put(path.get(index), content);
            }
        } else if(index<path.size()-1){
            if(directory.directorMap.containsKey(path.get(index)))
                addContentToFile(path, index+1, directory.directorMap.get(path.get(index)), content);
            else {
                directory.directorMap.put(path.get(index), new Directory());
                addContentToFile(path, index+1, directory.directorMap.get(path.get(index)), content);
            }
        }
    }

    public String readContentFromFile(List<String> path, int index, Directory directory) {
        if(index==path.size()-1) {
            return directory.fileMap.get(path.get(index));
        } else {
            return readContentFromFile(path, index+1, directory.directorMap.get(path.get(index)));
        }
    }
}
