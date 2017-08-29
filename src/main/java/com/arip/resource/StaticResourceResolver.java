package com.arip.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Arip Hidayat on 8/30/2017.
 */
public class StaticResourceResolver implements ResourceResolver {

    @Override
    public Resource resolveResource(HttpServletRequest request, String requestPath, List<? extends Resource> locations, ResourceResolverChain chain) {
        return getResource(requestPath, locations);
    }

    @Override
    public String resolveUrlPath(String resourcePath, List<? extends Resource> locations, ResourceResolverChain chain) {
        Resource resource = getResource(resourcePath, locations);
        if (resource == null) {
            return null;
        }
        try {
            return resource.getURL().toString();
        } catch (IOException e) {
            return resource.getFilename();
        }
    }

    private Resource getResource(String resourcePath, List<? extends Resource> locations) {

        for (Resource location: locations) {
            Resource resource = getResource(resourcePath, location);
            if (resource != null && resource.exists()) {
                return resource;
            }
        }

        return new ClassPathResource("/static/index.html");
    }

    private Resource getResource(String resourcePath, Resource location) {
        try {
            return location.createRelative(resourcePath);
        } catch (IOException e) {
            return null;
        }
    }
}
