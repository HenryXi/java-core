package com.henryxi.core.util.collection.list.groupby;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByBeanClient {
    public static void main(String[] args) {
        App app1 = new App(true);
        App app2 = new App(false);
        App app3 = new App(true);
        App app4 = new App(true);
        App app5 = new App(false);
        App app6 = new App(true);
        App app7 = new App(true);
        App app8 = new App(false);
        List<App> allApps = new LinkedList<>();
        allApps.addAll(Arrays.asList(app1, app2, app3, app4, app5, app6, app7, app8));

        Map<Boolean, List<App>> group = allApps.stream().collect(Collectors.groupingBy(App::isInstall));
        List<App> finalList = new LinkedList<>();
        finalList.addAll(group.get(true));
        finalList.addAll(group.get(false));
        System.out.println(finalList);
    }
}
