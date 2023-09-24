package com.obiscr.template;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State( name = "com.obiscr.template.MyState", storages = @Storage("my-state/state.xml"))
public class MyState implements PersistentStateComponent<MyState> {
    public String currentVersion = "";
    public Boolean enableFeature = true;
    public String myCustomKey = "";

    public static MyState getInstance(@NotNull Project project) {
        return project.getService(MyState.class);
    }

    @Nullable
    @Override
    public MyState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull MyState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

}
