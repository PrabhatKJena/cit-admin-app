package in.cit.apps.admin.model.enums;

/**
 * Created by Prabhat on 4/23/2017.
 */
public enum TemplateEnum {
    HOME("home-template"),
    ONBOARD("onboard-template"),
    FINANCE("finance-template"),
    REPORT("report-template"),
    ERROR("error-template"),
    LOGIN("login-template");

    private String template;

    TemplateEnum(String name) {
        this.template = name;
    }

    public String getTemplate() {
        return template;
    }
}
