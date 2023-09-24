package com.obiscr.template;

import com.intellij.openapi.fileTypes.INativeFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class MyDefaultFileType implements INativeFileType {

    public static final MyDefaultFileType INSTANCE = new MyDefaultFileType();

    @Override
    public boolean openFileInAssociatedApplication(Project project, @NotNull VirtualFile file) {
        if (project == null) {
            return false;
        }
        // TODO Do your default action here
        return false;
    }

    @Override
    public boolean useNativeIcon() {
        return false;
    }

    @Override
    public @NonNls
    @NotNull String getName() {
        return "MyNativeFile";
    }

    @Override
    public @NotNull String getDescription() {
        return "J file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "j;J";
    }

    @Override
    public Icon getIcon() {
        return MyIcons.ICON_J;
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public @NonNls
    @NotNull String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        return CharsetToolkit.UTF8;
    }
}
