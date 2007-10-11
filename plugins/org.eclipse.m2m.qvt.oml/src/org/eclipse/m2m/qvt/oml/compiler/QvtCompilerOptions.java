package org.eclipse.m2m.qvt.oml.compiler;

/**
 * @author aigdalov
 * Created on Aug 10, 2007
 */

public class QvtCompilerOptions {
    private boolean isReportErrors = true;
    private boolean isShowAnnotations = true;
    private boolean isGenerateCompletionData = true;
    private boolean isWorkspaceModelResolutionEnabled = true;
    
    public boolean isReportErrors() {
        return isReportErrors;
    }
    
    public void setReportErrors(boolean reportErrors) {
        isReportErrors = reportErrors;
    }
    
    public boolean isGenerateCompletionData() {
        return isGenerateCompletionData;
    }
    
    public void setGenerateCompletionData(boolean generateCompletionData) {
        isGenerateCompletionData = generateCompletionData;
    }

    public boolean isShowAnnotations() {
        return isShowAnnotations;
    }

    public void setShowAnnotations(boolean showAnnotations) {
        isShowAnnotations = showAnnotations;
    }

    public boolean isWorkspaceModelResolutionEnabled() {
        return isWorkspaceModelResolutionEnabled;
    }

    public void setWorkspaceModelResolutionEnabled(boolean workspaceModelResolutionEnabled) {
        isWorkspaceModelResolutionEnabled = workspaceModelResolutionEnabled;
    }
}