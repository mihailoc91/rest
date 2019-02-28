/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practice.mobile.app.ws.ui.model.response;

/**
 *
 * @author Mihailo
 */
public class OperationStatusModel {
    
    private String operationResult;
    private String operationName;

    /**
     * @return the operationResult
     */
    public String getOperationResult() {
        return operationResult;
    }

    /**
     * @param operationResult the operationResult to set
     */
    public void setOperationResult(String operationResult) {
        this.operationResult = operationResult;
    }

    /**
     * @return the operationName
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * @param operationName the operationName to set
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
    
}
