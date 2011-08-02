///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package es.lda.core.lib.driver.zes.impl;
//
///**
// *
// * @author Jose Antonio
// */
//public interface IZES {
//
//    /**
//     * Procedimiento que cierra las conexiones del equipo.
//     *
//     * Libera la memoria del equipo
//     */
//    void Close();
//
//    /**
//     * Destructor de la clase
//     *
//     */
//    void Dispose();
//
//    /**
//     * Procedimiento que devuelve el estado del equipo
//     *
//     */
//    boolean FbDSPActivo(int Estado);
//
//    /**
//     * Procedimiento de desactiva las comunicaciones con el equipo
//     *
//     */
//    void PFinish();
//
//    /**
//     * Procedimiento que consulta el estado del amplificador, es decir, te dice si el amplificador del equipo esta Activo o Desactivo.
//     *
//     * @param Estado Es el estado del amplificador, es decir, Si es TRUE el amplificador esta activo, Si es FALSE el amplificador esta desactivo.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetAmplificador(boolean Estado);
//
//    /**
//     * Procedimiento que consulta el estado del atenuador, es decir, te dice si el atenuador del equipo esta Activo o Desactivo.
//     *
//     * @param Estado Es el estado del atenuador, es decir, Si es TRUE el atenuador esta activo, Si es FALSE el atenuador esta desactivo.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetAtenuador24V(boolean Estado);
//
//    /**
//     * Obtiene el valor asignado a un Bundle de entrada
//     *
//     * @param Bundle Es el bundle del que se quiere saber su valor
//     * @param Dato Es el valor del bundle que tienes asignado, El Rango del valor del Bundle va del 0 al 65535
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetBundleEntrada(int Bundle, int Dato);
//
//    /**
//     * Obtiene el valor asignado de un Bundle de salida
//     *
//     * @param Bundle Es el bundle del que se quiere saber su valor
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Dato Es el valor del bundle que tienes asignado, El Rango del valor del Bundle va del 0 al 65535
//     */
//    int PGetBundleSalida(int Bundle, int Dato);
//
//    /**
//     * Procedimiento que devuelve el estado de los busy.
//     *
//     * @param Cierre Indice del cierre a consultar
//     * @param Act Indica si el cierre está activo o no
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetCierre(int Cierre, boolean Act);
//
//    int PGetCompresorAttack(int Entrada, int Valor);
//
//    int PGetCompresorBypass(int Entrada, int Valor);
//
//    int PGetCompresorRatio(int Entrada, int Valor);
//
//    int PGetCompresorRelease(int Entrada, int Valor);
//
//    int PGetCompresorSoftknee(int Entrada, int Valor);
//
//    int PGetCompresorThreshold(int Entrada, int Valor);
//
//    /**
//     * Procedimiento que devuelve si esta configurado las comunicaciones Rs-485.
//     *
//     * @param Act
//     * TRUE Esta activa las comunicaciones 485.
//     * FALSE Esta desactiva las comunicaciones 485.
//     *
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PGetComunicaciones485(boolean Act);
//
//    /**
//     * Procedimiento que devuelve si esta configurado los atenuadores para la gestión automática de micrófonos.
//     *
//     * @param Act
//     * TRUE Esta activa los atenuadores para la gestión automática de micrófonos.
//     * FALSE Esta desactiva los atenuadores para la gestión automática de micrófonos.
//     *
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PGetConfigAtenuadores(boolean Act);
//
//    /**
//     * Procedimiento que configura un cierre.
//     *
//     * @param Indice Es el indice del cierre que se quiere configurar.
//     * @param Sal Si es 1, está configurado el cierre como salida, sino como entrada.
//     * @param Alt Si es 1, está configurado el cierre a nivel alto, sino a nivel bajo.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetConfigCierres(int Indice, boolean Sal, boolean Alt);
//
//    /**
//     * Procedimiento que devuelve si esta activo o no la gestion automatica de Microfonos.
//     *
//     * @param Act
//     * TRUE Esta activo la gestion automatica de microfonos.
//     * FALSE Esta desactivo la gestion automatica de microfonos.
//     *
//     * @param ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PGetConfigGestionAutomaticaMicrofonos(boolean Act);
//
//    /**
//     * Devuelve un dato de una direccion HMI
//     *
//     * @param AddressHMI Es la direccion HMI que se quiere consultar
//     * @param Dato Es el valor del dato que hay en la direccion HMI
//     * @return Ok
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetDatoDSP(String AddressHMI, int Dato);
//
//    /**
//     * Procedimiento que devuelve la ganancia de entrada
//     * @param Entrada Es la entrada de la que se quiere saber su ganancia
//     * @param Ganancia Es la ganancia del canal fisico de entrada que tiene asignada.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * El valor de la ganancia va de -100 a  12
//     */
//    int PGetGananciaCFE(int Entrada, int Ganancia);
//
//    /**
//     * Procedimiento que devuelve la ganancia de la salida fisica.
//     *
//     * @param Salida Es la salida donde se quiere saber su ganancia
//     * @param Ganancia Es la ganancia del canal fisico de salida que tiene asignada.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * El valor de la ganancia va de -100 a 12
//     */
//    int PGetGananciaCFS(int Salida, int Ganancia);
//
//    int PGetLimitadorAttack(int Salida, int Valor);
//
//    int PGetLimitadorBypass(int Salida, int Valor);
//
//    int PGetLimitadorRatio(int Salida, int Valor);
//
//    int PGetLimitadorRelease(int Salida, int Valor);
//
//    int PGetLimitadorSoftknee(int Salida, int Valor);
//
//    int PGetLimitadorThreshold(int Salida, int Valor);
//
//    /**
//     * Procedimiento que lee el estado del mp3.
//     *
//     * @param Reproduciendo Indica sie el mp3 está reproduciendo  o no.
//     * @param Pista Pista que actualmente se está reproduciendo
//     * @param NumPistas Número de pistas contenidas enb la sd
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetMP3(boolean Reproduciendo, int Pista, int NumPistas);
//
//    /**
//     * Procedimiento que comprueba si el mp3 del zes existe.
//     *
//     * @param Existe Si 1 el mp3 existe
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetMP3In(boolean Existe);
//
//    /**
//     * Procedimiento que comprueba si el modulo de expansión del zes existe.
//     *
//     * @param Existe Si 1 el modulo de expansion existe
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetModExpansionIn(boolean Existe);
//
//    /**
//     * Devuelve el valor del RxSubMap
//     *
//     * @param Bundle El Bundle del que se quiere saber el TxSubMap
//     * @param canal Es el Sub-canal del Bundle
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Dato Es el valor que tiene asignado
//     * Los posibles valores pueden se enre 1 y 8
//     */
//    int PGetRxSubMap(int Bundle, int Canal, int Dato);
//
//    /**
//     * Procedimiento que comprueba si la sd del zes existe.
//     *
//     * @param Existe Si 1 la sd existe
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetSDIn(boolean Existe);
//
//    /**
//     * Procedimiento que comprueba si la sd del zes está protegida.
//     *
//     * @param Protegida Si 1 la sd está protegida
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetSDProtect(boolean Protegida);
//
//    /**
//     * Procedimiento que te devuelve la entrada asignada que tiene la salida dada
//     *
//     * @param Salida Es la salida que se desea saber cual es la entrada asignada
//     * @param Entrada Es la entrada que tiene asignada
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * Las salida se dividen de la 1 a la 8 en salidas fisicas y de la 9 a la 16 son salidas CobraNet
//     */
//    int PGetSalida(int Salida, int Entrada);
//
//    /**
//     * Procedimiento que consulta el estado de la temperatura del equipo y su ventilacion.
//     *
//     * @param Temp1 Es la temperatura del primer sensor, en grados centigrador.
//     * @param Vent1 Es el flag de si esta o no activo la ventilacion.
//     * @param Temp2 Es la temperatura del segundo sensor, en grados centigrador.
//     * @param Vent2 Es el flag de si esta o no activo la ventilacion.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PGetTemperatura(int Temp1, boolean Vent1, int Temp2, boolean Vent2);
//
//    /**
//     *
//     * @param Salida
//     * @param Valor
//     * @return Ok
//     */
//    int PGetTono(int Salida, int Valor);
//
//    int PGetTonoFrec(int Valor);
//
//    int PGetTonoMaster(int Valor);
//
//    /**
//     * Devuelve el valor del TxSubMap
//     *
//     * @param Bundle El Bundle del que se quiere saber el TxSubMap
//     * @param canal Es el Sub-canal del Bundle
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Dato Es el valor que tiene asignado
//     * Los posibles valores pueden se enre 1 y 8
//     */
//    int PGetTxSubMap(int Bundle, int Canal, int Dato);
//
//    /**
//     * Devuelve el nivel dB de un canal de entrada dado, ya se canal fisico ó canal cobranet
//     *
//     * @param Entrada Es la entrada que se quiere saber el nivel dB.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Valor El valor devuelto va ente -100 y 12
//     */
//    int PGetVumetroCE(int Entrada, int Valor);
//
//    /**
//     * Devuelve el nivel dB de un canal de salida dado, ya se canal fisico ó canal cobranet.
//     *
//     * @param Salida Es la salida que se quiere saber el nivel dB.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Valor El valor devuelto va entre -100 y 12
//     */
//    int PGetVumetroCS(int Salida, int Valor);
//
//    /**
//     * Procedimiento que cambia el estado del amplificador, es decir, Activa o Desactiva el amplificador del equipo.
//     *
//     * @param Estado Es el nuevo estado del amplificador, es decir, Si es TRUE el amplificador se va a activar, Si es FALSE el amplificador se va a desactivar
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetAmplificador(boolean Estado);
//
//    /**
//     * Procedimiento que cambia el estado del atenuador, es decir, Activa o Desactiva el atenuador del equipo.
//     *
//     * @param Estado Es el nuevo estado del atenuador, es decir, Si es TRUE el atenuador se va a activar, Si es FALSE el atenuador se va a desactivar
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetAtenuador24V(boolean Estado);
//
//    /**
//     *
//     * Asigna el valor de un Bundle de entrada dado.
//     *
//     * @param BundleEntrada Es el Bundle al que queremos asignar un valor. Los Bundle de entradas van del 1 al 4.
//     * @param vBundle Es el valor del Bundle. Su valor va del 0 al 65535.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetBundleEntrada(int BundleEntrada, int vBundle);
//
//    /**
//     *
//     * Asigna el valor de un Bundle de salida dado.
//     *
//     * @param BundleSalida Es el Bundle al que queremos asignar un valor. Los Bundle de salida van del 1 al 4.
//     * @param vBundle Es el valor del Bundle. Su valor va del 0 al 65535.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetBundleSalida(int BundleSalida, int vBundle);
//
//    /**
//     * Procedimiento que activa o desactiva un cierre
//     *
//     * @param Indice Es el Indice que se quiere enviar el busy
//     * @param Activar Es el valor del busy. Si es 1 se activa el cierre y si es 0 se desactiva.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetCierre(int Indice, boolean Activar);
//
//    /**
//     * Procedimiento que activa / desactiva las comunicaciones Rs-485
//     *
//     * @param Act
//     * TRUE Activa las comunicaciones 485.
//     * FALSE Desactiva las comunicaciones 485.
//     *
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PSetComunicaciones485(boolean Act);
//
//    /**
//     * Procedimiento que configura si los atenuadores se activan para la gestión automática de micrófonos.
//     *
//     * @param Act
//     * TRUE Esta activa los atenuadores para la gestión automática de micrófonos.
//     * FALSE Esta desactiva los atenuadores para la gestión automática de micrófonos.
//     *
//     * @return Ok
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PSetConfigAtenuadores(boolean Act);
//
//    /**
//     * Procedimiento que configura un cierre.
//     *
//     * @param Indice Es el indice del cierre que se quiere configurar.
//     * @param Salida Si es 1, configura el cierre como salida, sino como entrada.
//     * @param Alto Si es 1, configura el cierre a nivel alto, sino a nivel bajo.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetConfigCierres(int Indice, boolean Salida, boolean Alto);
//
//    /**
//     * Procedimiento que configura la gestiion automatica de microfonos.
//     *
//     * @param Act
//     * TRUE Activa la gestion automatica de microfonos.
//     * FALSE Desactiva la gestion automatica de microfonos.
//     *
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1 Ok.
//     * 2 Error en los parametros.
//     * 3 Error Equipo desconectado.
//     * 4 El equipo se esta Sincronizando con la dll.
//     * 5 La versión de firmware no es compatible con la funcion.
//     *
//     */
//    int PSetConfigGestionAutomaticaMicrofonos(boolean Act);
//
//    /**
//     * Asigna un dato al DSP
//     *
//     * @param AddressHMI Es la direccion del HMI. es un String en base Hexadecimal.
//     * @param Dato Es el valor del dato que se va a enviar o asignar.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetDatoDSP(String AddressHMI, int Dato);
//
//    /**
//     * Asigna la Ganancia de un canal fisico de entrada.
//     *
//     * @param Entrada Es el canal fisico que se desea asignar la ganancia.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Ganancia Es la ganancia que se desea asignar.
//     * El valor de la ganancia oscila entre -100 a 12.
//     */
//    int PSetGananciaCFE(int Entrada, int Ganancia);
//
//    /**
//     * Asigna la Ganancia de un canal fisico de salida.
//     *
//     * @param Salida Es el canal de fisico de salida que se desea asignar la ganancia.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Ganancia Es la ganancia que se desea asignar.
//     * El valor de la ganancia oscila entre -100 a 12.
//     */
//    int PSetGananciaCFS(int Salida, int Ganancia);
//
//    /**
//     * Procedimiento que maneja el MP3.
//     *
//     * @param Play Si true inicia el mp3, si false lo para.
//     * @param Pista Si 0, reproduce todas las pistas de la SD, en este caso el valor de looping no se tiene en cuenta. Sino, reproduce la pista seleccionada y despues para
//     * @param Looping Si 1 y pista es distinto de 0, se reproduce el mensaje indefinidamente. Si 0 y pista distinta de x. Al terminar la pista se para el mp3
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetMP3(boolean Play, int Pista, boolean Looping);
//
//    /**
//     * Guarda o Borra un preset al equipo.
//     *
//     * @param Accion Es la accion que se va ha realizar. Si es TRUE va a guardar un preset y Si es un FALSE va a borrar el preset
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetPreset(boolean Accion);
//
//    /**
//     * Envia un reset al equipo
//     *
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * El equipo se va a resetear
//     */
//    int PSetReset();
//
//    /**
//     *
//     * Asigna el valor del RxSubMap.
//     *
//     * @param Bundle Es el Bundle de salida del que se quiere asignar el valor del Sub-canal. Los posibles valores del bundle pueden ser entre 1 y 4.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     * @param Canal Es el Sub-Canal que se quiere asignar un valor. Los posibles valores del Sub-canal pueden ser entre 1 y 8.
//     * @param Vcanal Es el valor del Sub-Canal que se quiere asignar. El valor del sub-canal puede ser entre 1 y 8
//     */
//    int PSetRxSubMap(int Bundle, int Canal, int Vcanal);
//
//    /**
//     *
//     * Asigna una Salida a una entrada
//     *
//     * @param Salida Es la salida a la que se le quiere asignar una entrada
//     * @param Entrada Es valor de la entrada que se quiere asignar.
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetSalida(int Salida, int Entrada);
//
//    /**
//     *
//     * @param Salida
//     * @param Valor
//     * @return
//     */
//    int PSetTono(int Salida, int Valor);
//
//    int PSetTonoFrec(int Valor);
//
//    /**
//     *
//     * @param Valor
//     * @return Ok
//     * @return
//     */
//    int PSetTonoMaster(int Valor);
//
//    /**
//     *
//     * Asigna el valor del TxSubMap.
//     *
//     * @param Bundle Es el Bundle de salida del que se quiere asignar el valor del Sub-canal. Los posibles valores del bundle pueden ser entre 1 y 4.
//     * @param Canal Es el Sub-Canal que se quiere asignar un valor. Los posibles valores del Sub-canal pueden ser entre 1 y 8.
//     * @param Vcanal Es el valor del Sub-Canal que se quiere asignar. El valor del sub-canal puede ser entre 1 y 8
//     * @return Ok Te indica si la funcion se ha ejecutado correctamente. Los posibles valores son:
//     * 1  ok.
//     * 2 Error en los parametros.
//     * 3 Error equipo desconectado.
//     * 4 El equipo se esta sincronizando con la dll.
//     */
//    int PSetTxSubMap(int Bundle, int Canal, int Vcanal);
//
//    /**
//     * Procedimiento que activa las comunicaciones con el equipo.
//     *
//     * @param dir_ip Es la direccion ip del equipo.
//     * @param puerto Es el puerto del equipo.
//     */
//    void PStart(String dir_ip, String puerto);
//    
//}
