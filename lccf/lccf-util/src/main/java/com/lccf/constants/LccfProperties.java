package com.lccf.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "lccf", ignoreUnknownFields = false)
public class LccfProperties {
    private final Swagger swagger = new Swagger();
    private final Mail mail = new Mail();
    public Swagger getSwagger() {
        return swagger;
    }
    public Mail getMail() {
        return mail;
    }

    public static class Swagger {

        private String title = "lccfApi";

        private String description = "lccf API documentation";

        private String version = "0.0.1";

        private String termsOfServiceUrl;

        private String contact;

        private String license;

        private String licenseUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }
    }
    public static class Mail {

        private String from = "tuxAdmin@localhost";

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }
    }

}

