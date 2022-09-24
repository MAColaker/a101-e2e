package org.colaker.Mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.colaker.helper.BaseHelper;
import org.colaker.helper.ElementHelper;
import org.colaker.model.ElementInfo;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Mapper {
    protected static final Logger logger = LoggerFactory.getLogger(BaseHelper.class);
    private static final String DEFAULT_DIRECTORY_PATH = "pageElements";
    ConcurrentMap<String, Object> elementMapList;

    public Mapper() {
        initMap(getFileList());
    }

    private void initMap(File[] files) {
        elementMapList = new ConcurrentHashMap<>();
        Type elementType = new TypeToken<List<ElementInfo>>() {
        }.getType();
        Gson gson = new Gson();
        for (File file : files) {
            try {
                List<ElementInfo> elementInfoList = gson
                        .fromJson(new FileReader(file), elementType);
                elementInfoList.parallelStream()
                        .forEach(elementInfo -> elementMapList.put(elementInfo.getKey(), elementInfo));
            } catch (FileNotFoundException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public File[] getFileList() {
        return new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(DEFAULT_DIRECTORY_PATH)).
                    getFile()).listFiles(pathname -> !pathname.isDirectory() && pathname.getName().endsWith(".json"));
    }

    public ElementInfo findElementInfoByKey(String key) {
        return (ElementInfo) elementMapList.get(key);
    }

    public By getElementByJson(String key) {
        ElementInfo elementInfo = findElementInfoByKey(key);
        return ElementHelper.getElementInfoToBy(elementInfo);
    }
}
