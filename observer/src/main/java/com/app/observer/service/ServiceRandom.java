package com.app.observer.service;

import io.micrometer.core.instrument.MeterRegistry;

public interface ServiceRandom {
    public String getNumberRandom();
    public String getUserById(long id);
}
