/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.lda.core.exception;

import java.util.List;

/**
 * Unsupporter Driver Operation.
 * @author Jose Antonio
 */
public class UnsupportedDriverOperation extends Exception {

    private String operationName;
    private List<String> params;
    
    /**
     * Creates a new instance of <code>UnsupportedDriverOperation</code> without detail message.
     */
    public UnsupportedDriverOperation() {
    }

    /**
     * Constructs an instance of <code>UnsupportedDriverOperation</code> with the specified detail message.
     * @param OpName Operation name.
     * @param paramList Param list.
     */
    public UnsupportedDriverOperation(String opName, List<String> paramsList) {
        super(opName);
        operationName = opName;
        params = paramsList;
    }

    /**
     * Get Operation name.
     * @return Operation name.
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * Set  Operation name.
     * @param operationName Operation name. 
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    /**
     * Get List Operation Params.
     * @return List Operation Params.
     */
    public List<String> getParams() {
        return params;
    }

    /**
     * Set List Operation Params.
     * @param params List Operation Params.
     */
    public void setParams(List<String> params) {
        this.params = params;
    }
        
}
