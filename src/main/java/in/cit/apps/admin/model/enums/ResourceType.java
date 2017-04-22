package in.cit.apps.admin.model.enums;

import in.cit.apps.admin.model.LoginData;
import in.cit.apps.admin.model.UserGroupsType;

import java.util.*;
import java.util.stream.Collectors;

import static in.cit.apps.admin.model.UserGroupsType.*;

/**
 * Created by Prabhat on 4/20/2017.
 */
public enum ResourceType {
    HOME("Home", "/home", UserGroupsType.values()),
    CLIENT_ONBOARD("ClientOnboard", "/clientOnboard", RECRUITER, ADMIN),
    CONSULTANT_ONBOARD("ConsultantOnboard", "/consultantOnboard", RECRUITER, ADMIN),
    FINANCE_CREDIT("FinanceCredit", "/finInReport", FINANCE, ADMIN),
    FINANCE_DEBIT("FinanceDebit", "/finOutReport", FINANCE, ADMIN),
    FINANCE_REPORT("FinanceReport", "/finReport", FINANCE, ADMIN);

    private static Map<String, ResourceType> resourcePathMap;

    static {
        // Storing all paths into EnumMap for faster validation
        resourcePathMap = Arrays.stream(ResourceType.values()).collect(Collectors.toMap(resourceType -> resourceType.getPath(), resourceType -> resourceType));
        System.out.println("Resource Type Map STATIC >>>>> " + resourcePathMap);
    }

    private String name;
    private Integer value;
    private String path;

    ResourceType(String name, String path, UserGroupsType... types) {
        this.name = name;
        this.value = Arrays.stream(types).mapToInt(type -> type.getGroupValue()).reduce((value1, value2) -> value1 ^ value2).orElse(0);
        this.path = path;
    }

    public boolean isValid(String path) {
        return resourcePathMap.containsKey(path);
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

    public boolean hasAccess(LoginData loginData, ResourceType resource) {
        return (loginData.getGroupValue() & resource.getValue()) > 0;
    }
}
