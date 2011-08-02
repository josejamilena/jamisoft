/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.lda.core.lib.driver.zes.impl;

/**
 *
 * @author Jose Antonio
 */
class Parametros {
    /// <summary>
    /// Parametros del proceso, si los tiene
    /// </summary>
    /// <remarks>Los parametros pueden ser estructuras ó datos simples</remarks>
    public int Parametros;
    /// <summary>
    /// Parametros del proceso, si los tiene
    /// </summary>
    /// <remarks>Es un parametro auxiliar en nuestro caso hace falta para las funciones TxSubMap y RxSubMap</remarks>
    public int Parametros2;
    /// <summary>
    /// Parametros del proceso, si los tiene
    /// </summary>
    /// <remarks>Es el parametro Normalizado es decir dato con las funciones de formateo para ser enviado por snmp </remarks>
    public double ParametrosSNMP;
    /// <summary>
    /// Parametros del proceso, si los tiene
    /// </summary>
    /// <remarks>Es el valor a asignar al parametro solicitado antes de haberlo formateado para luego ser enviado por snmp</remarks>
    public int VParametros;
    /// <summary>
    /// Parametros del proceso, si los tiene
    /// </summary>
    public String VParametrosS;
    ZESImpl tParametros;

    Parametros(ZESImpl tParametros) {
        this.tParametros = tParametros;
    }
    
}
