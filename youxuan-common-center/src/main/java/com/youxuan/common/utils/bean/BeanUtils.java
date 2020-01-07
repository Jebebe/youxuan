package com.youxuan.common.utils.bean;

import java.util.*;

/**
 * @Author: Jebe
 * @Date: 2019/12/18 22:19
 */
public class BeanUtils {

    public BeanUtils() {
    }

    public static <T> T map(Object source, Class<T> target) {
        if (Objects.isNull(source)) {
            throw new NullPointerException("转换对象参数为空!");
        } else {
            T t = null;
            try {
                t = target.newInstance();
                copyProperties(source, t);
            } catch (InstantiationException | IllegalAccessException e) {
                e.getMessage();
            }
            return t;
        }
    }

    public static <T> List<T> mapList(Collection sourceList, Class<T> target) {
        if (null == sourceList) {
            return null;
        } else {
            List<T> destinationList = new ArrayList<T>();
            sourceList.forEach(sourceObject -> {
                T newObj = map(sourceObject, target);
                destinationList.add(newObj);
            });
            return destinationList;
        }
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) {
        if (null != source && null != target) {
            org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
        }
    }

}