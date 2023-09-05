package com.henryxi.core.util.collection.list.groupby;

public class App {
    private boolean install;

    public App() {
    }

    public App(boolean install) {
        this.install = install;
    }

    public boolean isInstall() {
        return install;
    }

    public void setInstall(boolean install) {
        this.install = install;
    }

    @Override
    public String toString() {
        return "App{" +
                "install=" + install +
                '}';
    }
}
