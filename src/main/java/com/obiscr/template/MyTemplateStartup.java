package com.obiscr.template;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

public class MyTemplateStartup implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {

        MyState state = project.getService(MyState.class);
        state.currentVersion = "v1.0.1";
        state.enableFeature = false;
        state.myCustomKey = "value";
    }
}
