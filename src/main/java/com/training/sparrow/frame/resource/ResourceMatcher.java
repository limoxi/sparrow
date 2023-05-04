package com.training.sparrow.frame.resource;

import org.springframework.util.PathMatcher;

import java.util.Comparator;
import java.util.Map;

public class ResourceMatcher implements PathMatcher {

    private String formatPath(String path) {
        String separator = "/";
        if (path.startsWith(separator)) {
            path = path.substring(1);
        }
        if (path.endsWith(separator)) {
            path = path.substring(0, path.length() - 1);
        }

        var newPath = path.replaceAll(separator, ".");
        return "/%s".formatted(newPath);
    }

    @Override
    public boolean isPattern(String path) {
        return false;
    }

    @Override
    public boolean match(String pattern, String path) {
        path = this.formatPath(path);
        return path.equals(pattern);
    }

    @Override
    public boolean matchStart(String pattern, String path) {
        return this.match(pattern, path);
    }

    @Override
    public String extractPathWithinPattern(String pattern, String path) {
        System.out.printf("extractPathWithinPattern---------------:%s-%s%n", pattern, path);
        return "";
    }

    @Override
    public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
        return null;
    }

    @Override
    public Comparator<String> getPatternComparator(String path) {
        return new ResourceComparator(this.formatPath(path));
    }

    @Override
    public String combine(String pattern1, String pattern2) {
        return "";
    }

    protected class ResourceComparator implements Comparator<String> {
        private final String path;

        public ResourceComparator(String path) {
            this.path = path;
        }

        public int compare(String pattern1, String pattern2) {
            pattern1 = ResourceMatcher.this.formatPath(pattern1);
            pattern2 = ResourceMatcher.this.formatPath(pattern2);
            boolean pattern1EqualsPath = pattern1.equals(this.path);
            boolean pattern2EqualsPath = pattern2.equals(this.path);
            if (pattern1EqualsPath && pattern2EqualsPath) {
                return 0;
            } else if (pattern1EqualsPath) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
