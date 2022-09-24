package org.colaker.Mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.colaker.helper.ElementHelper;
import org.colaker.model.ElementInfo;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Mapper {
    private static final String DEFAULT_DIRECTORY_PATH = "pageElements";
    ConcurrentMap<String, Object> elementMapList;

    public Mapper() {
        initMap(getFileList());
    }

    private void initMap(File[] fileList) {
        elementMapList = new ConcurrentHashMap<>();
        Type elementType = new TypeToken<List<ElementInfo>>() {
        }.getType();
        Gson gson = new Gson();
        List<ElementInfo> elementInfoList;
        for (File file : fileList) {
            try {
                elementInfoList = gson
                        .fromJson(new FileReader(file), elementType);
                elementInfoList.parallelStream()
                        .forEach(elementInfo -> elementMapList.put(elementInfo.getKey(), elementInfo));
            } catch (FileNotFoundException e) {
                //logger.warn("{} not found", e);
            }
        }
    }

    private File[] getFileList() {
        File[] fileList = new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(DEFAULT_DIRECTORY_PATH)).getFile())
                .listFiles(pathname -> !pathname.isDirectory() && pathname.getName().endsWith(".json"));
        if (fileList == null) {
            throw new NullPointerException("Belirtilen dosya bulunamadı.");
        }
        return fileList;
    }

    public ElementInfo findElementInfoByKey(String key) {
        return (ElementInfo) elementMapList.get(key);
    }

    public By getElementByJson(String key) {
        ElementInfo elementInfo = findElementInfoByKey(key);
        return ElementHelper.getElementInfoToBy(elementInfo);
    }
}
