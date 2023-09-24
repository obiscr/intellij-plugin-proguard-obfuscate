package com.obiscr.template;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.actionSystem.impl.ActionToolbarImpl;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBPanelWithEmptyText;
import com.intellij.util.ui.JBUI;
import com.intellij.util.ui.UIUtil;
import com.obiscr.template.MyIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainPanel implements Disposable {

    private final JPanel rootPanel;
    private final JPanel centerPanel;


    public MainPanel() {
        rootPanel = new JPanel(new BorderLayout());
        centerPanel = new JBPanelWithEmptyText()
                .withEmptyText("Hello, this is empty text.");
        centerPanel.setBorder(JBUI.Borders.empty(10));

        DefaultActionGroup actionGroup = new DefaultActionGroup();
        AnAction action1 = new AnAction(() -> "Action 1", MyIcons.ICON_1) {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                Messages.showInfoMessage("Action1 triggered","Action1");
            }
        };

        AnAction action2 = new AnAction(() -> "Action 2", MyIcons.ICON_2) {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                Messages.showInfoMessage("Action2 triggered","Action2");
            }
        };

        AnAction action3 = new AnAction(() -> "Action 3", MyIcons.ICON_3) {
            @Override
            public void actionPerformed(@NotNull AnActionEvent e) {
                Messages.showInfoMessage("Action3 triggered","Action3");
            }
        };
        actionGroup.add(action1);
        actionGroup.add(action2);
        actionGroup.add(action3);
        ActionToolbarImpl actionToolbar = new ActionToolbarImpl("MyPanelToolbar", actionGroup, true);
        actionToolbar.setTargetComponent(rootPanel);
        actionToolbar.setBorder(JBUI.Borders.customLine(UIUtil.getBoundsColor(), 1,0,1,0));
        rootPanel.add(actionToolbar, BorderLayout.NORTH);
        rootPanel.add(centerPanel, BorderLayout.CENTER);
    }

    public JPanel getComponent() {
        return rootPanel;
    }

    @Override
    public void dispose() {
        centerPanel.removeAll();
        rootPanel.removeAll();
    }

}
