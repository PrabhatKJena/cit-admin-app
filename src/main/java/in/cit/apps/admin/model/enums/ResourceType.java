package in.cit.apps.admin.model.enums;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Prabhat on 4/20/2017.
 */
public enum ResourceType {
    HOME("Home", 7, "/home"),
    CLIENT_ONBOARD("ClientOnboard", 7, "/clientOnboard"),
    CONSULTANT_ONBOARD("ConsultantOnboard", 7, "/consultantOnboard"),
    FINANCE_CREDIT("FinanceCredit", 4, "/finInReport"),
    FINANCE_DEBIT("FinanceDebit", 4, "/finOutReport"),
    FINANCE_REPORT("FinanceReport", 4, "/finReport");

    private String name;
    private Integer value;
    private String path;

    private static Set<String> resourcePathSet;

    static {
        // Storing all paths into Set
        resourcePathSet = Arrays.stream(ResourceType.values()).map(resourceType -> resourceType.path).collect(Collectors.toSet());
    }

    ResourceType(String name, Integer value, String path) {
        this.name = name;
        this.value = value;
        this.path = path;
    }

    public boolean isValid(String path) {
        return resourcePathSet.contains(path);
    }

    public ResourceType forPath(String path) {
        if (!isValid(path))
            throw new IllegalArgumentException("Wrong path");
        return Arrays.stream(ResourceType.values()).filter(type -> type.equals(path)).findFirst().get();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
