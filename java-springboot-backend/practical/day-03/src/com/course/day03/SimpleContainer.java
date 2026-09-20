package com.course.day03;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Tiny IoC container for learning. Real Spring also handles cycles, scopes,
 * proxies, qualifiers, and lifecycle callbacks.
 */
public class SimpleContainer {

    private final Map<Class<?>, Object> beans = new HashMap<>();

    public void register(Class<?> type, Object instance) {
        beans.put(type, instance);
    }

    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> type) {
        Object bean = beans.get(type);
        if (bean == null) {
            throw new IllegalStateException("No bean of type " + type.getName());
        }
        return (T) bean;
    }

    public <T> T create(Class<T> type) {
        try {
            Constructor<?> constructor = type.getDeclaredConstructors()[0];
            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                args[i] = getBean(paramTypes[i]);
            }
            @SuppressWarnings("unchecked")
            T instance = (T) constructor.newInstance(args);
            register(type, instance);
            return instance;
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("Cannot create " + type.getName(), ex);
        }
    }
}
