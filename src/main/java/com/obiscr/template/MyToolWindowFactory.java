package com.obiscr.template;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class MyToolWindowFactory implements ToolWindowFactory {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.getInstance();
        MainPanel panel = new MainPanel();
        Content content = contentFactory.createContent(panel.getComponent(), "ProGuard Obfuscate", false);
        content.setDisposer(panel);
        toolWindow.getContentManager().addContent(content);
    }
}
