//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shan.utils;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;

public class BeanTransferUtils {
    private static final Logger log = LoggerFactory.getLogger(BeanTransferUtils.class);

    private BeanTransferUtils() {
    }

    public static <T, K> K transferColumn(T source, Class<T> sourceClazz, Class<K> targetClazz) throws Exception {
        if (source == null) {
            return getInstance(targetClazz);
        } else {
            K targetBean = getInstance(targetClazz);
            BeanCopier.create(sourceClazz, targetClazz, false).copy(source, targetBean, (Converter)null);
            return targetBean;
        }
    }

    public static <T, K> List<K> transferColumn(List<T> sourceList, Class<T> sourceClazz, Class<K> targetClazz) throws Exception {
        if (CollectionUtils.isEmpty(sourceList)) {
            return Collections.emptyList();
        } else {
            List result = Lists.newArrayList();
            BeanCopier beanCopier = BeanCopier.create(sourceClazz, targetClazz, false);
            for (Iterator localIterator = sourceList.iterator(); localIterator.hasNext(); ) { Object source = localIterator.next();
                Object targetBean = getInstance(targetClazz);
                beanCopier.copy(source, targetBean, null);
                result.add(targetBean);
            }

            return result;
        }
    }

    public static <T, K> K bean2bean(T from, K to) {
        BeanCopier beanCopier = BeanCopier.create(from.getClass(), to.getClass(), false);
        beanCopier.copy(from, to, (Converter)null);
        return to;
    }

    public static <T> Map<String, Object> bean2Map(T bean) {
        if (bean == null) {
            return Collections.emptyMap();
        } else {
            BeanMap beanMap = BeanMap.create(bean);
            Map<String, Object> result = new HashMap(beanMap.size());
            result.putAll(beanMap);
            return result;
        }
    }

    public static <T> T map2Bean(Map<String, Object> sourceMap, Class<T> targetClazz) {
        T bean = null;
        try {
            bean = targetClazz.newInstance();
            if (MapUtils.isNotEmpty(sourceMap)) {
                BeanMap beanMap = BeanMap.create(bean);
                beanMap.putAll(sourceMap);
            }
        } catch (Exception e) {
            log.error("", e);
        }
        return bean;
    }

    public static <T> List<Map<String, Object>> beanList2Map(List<T> beanList) {
        if (CollectionUtils.isEmpty(beanList)) {
            return Collections.emptyList();
        }
        List list = new ArrayList(beanList.size());
        Iterator localIterator;
        if (CollectionUtils.isNotEmpty(beanList))
            for (localIterator = beanList.iterator(); localIterator.hasNext(); ) { Object bean = localIterator.next();
                if (bean != null)
                {
                    BeanMap beanMap = BeanMap.create(bean);
                    Map result = new HashMap(beanMap.size());
                    result.putAll(beanMap);
                    list.add(result);
                }
            }
        return list;
    }

    public static <T> T getInstance(Class<T> clazz) throws Exception {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException var2) {
            log.info("", var2);
            throw new Exception(var2);
        }
    }
}
