package com.suyh.demo3601.service;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class CustomEventPublishService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        eventPublisher = applicationEventPublisher;
    }

    /**
     * 发布一个事件
     * @param event 事件对象
     */
    public void publishEvent(ApplicationEvent event) {
        eventPublisher.publishEvent(event);
    }
}
