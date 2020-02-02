package com.elio.edu.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final String fileUploadPath;

    public WebConfig(@Value("${custom.upload-path}") String fileUploadPath) {
        this.fileUploadPath = fileUploadPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        List<String> fileFolders = Arrays.asList("/upload");
        for (String fileFolder : fileFolders) {
            registry.addResourceHandler(fileFolder + "/**")
                    .addResourceLocations("file://" + fileUploadPath)
                    .setCachePeriod(3600)
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver());
        }
    }
}
