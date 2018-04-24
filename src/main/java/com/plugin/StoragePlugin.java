package com.plugin;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Plugin - 存储
 *
 * @author Reach Team
 * @version 1.0
 */
public abstract class StoragePlugin implements Comparable<StoragePlugin> {

    /**
     * 获取ID
     *
     * @return ID
     */
    public final String getId() {
        return getClass().getAnnotation(Component.class).value();
    }


    public abstract String getName();


}