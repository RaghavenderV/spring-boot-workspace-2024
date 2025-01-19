package com.vodapally.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.xml.JobExecutionListenerParser;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerParser {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JobCompletionNotificationListener.class);

}
